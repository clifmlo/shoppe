package com.assessment.shoppe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.shoppe.repo.ProductRepository;
import com.assessment.shoppe.service.ProductService;
import com.assessment.shoppe.service.CustomerService;
import com.assessment.shoppe.service.ActiveDayService;
import com.assessment.shoppe.util.PurchaseRequest;
import com.assessment.shoppe.util.ResponseObject;
import com.assessment.shoppe.model.ActiveDay;
import com.assessment.shoppe.model.Customer;
import com.assessment.shoppe.model.Product;


@RestController
@RequestMapping("/product")
public class ProductsController {
	Logger logger = LoggerFactory.getLogger(ProductsController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ActiveDayService activeDayService;
	
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return productService.findAll();		
	}
	
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public ResponseEntity purchase(@RequestBody PurchaseRequest purchaseRequest) {		
		logger.info("Received request: " + purchaseRequest.toString());
		
		ResponseObject response = new ResponseObject(); 
		List<Product> nonExistentProducts = new ArrayList();
				
		//The customer ID does not exist	
		if(!customerExists(purchaseRequest.getCustomerId())){		
			response.setResultCode("1");
			response.setResultMsg("Purchase Failed. Customer Does not Exist.");			
			
			return new ResponseEntity<>(response, HttpStatus.OK);			
		}
		
		//The customer did not provide any products to purchase
		if(purchaseRequest.getProducts() != null && purchaseRequest.getProducts().isEmpty()){ 
			response.setResultCode("1");
			response.setResultMsg("Purchase Failed. No products provided for purchase.");			
			
			return new ResponseEntity<>(response, HttpStatus.OK);				
		}
		
		if(purchaseRequest.getProducts() != null){		
			nonExistentProducts = productsExist(purchaseRequest.getProducts());
		}
		
		//The customer chose non-existent product(s) code		
		if(!nonExistentProducts.isEmpty()){ 
			List<String> nonExistentProductCodes = new ArrayList();
			nonExistentProducts.forEach(p -> nonExistentProductCodes.add(p.getCode()));
			response.setResultCode("1");
			response.setResultMsg("Purchase Failed. The following poduct code(s) were not found: " + nonExistentProductCodes.toString());	
			
			return new ResponseEntity<>(response, HttpStatus.OK);		
		}
		
		//The customer does not have enough points
		if(!customerHasEnoughtPoints(purchaseRequest)){ 
			response.setResultCode("1");
			response.setResultMsg("Purchase Failed. Customer Does not have enough points.");	
			
			return new ResponseEntity<>(response, HttpStatus.OK);	
	    }
		
		//Process transaction
	    processPurchase(purchaseRequest); 
    	response.setResultCode("0");
		response.setResultMsg("Purchase Processed sucessfully");
		
	    return new ResponseEntity<>(response, HttpStatus.OK);		
	}
	
	private List<Product> productsExist(List<Product> products){
		List<Product> nonExistentProducts = products.stream()
														.filter(p -> findProductByCode(p.getCode()) == null)													
														.collect(Collectors.toList());
		
		return nonExistentProducts;
	}
	
	private boolean customerExists(int customerId){
		return customerService.findCustomerById(customerId) != null;
	}
	
	private Product findProductByCode(String code){
		return productService.findProductByCode(code);
	}
	
	private List<Product> findProductsByCodes(List<String> codes){
		return productService.findProductsByCodes(codes);
	}
	
	private boolean customerHasEnoughtPoints(PurchaseRequest purchaseRequest) {
		List<String> productCodes = getProductCodes(purchaseRequest);																					
		List<Product> products = findProductsByCodes(productCodes);
		 
		int totalPointRequired = calculateTotalPoints(products);
		int customerTotalPoints = getTotalCustomerPoints(purchaseRequest.getCustomerId());
		
		return isSuffientPoints(totalPointRequired, customerTotalPoints);
    }

    
	private Integer getTotalCustomerPoints(int customerId){		
		ActiveDay activeDay = activeDayService.getTotalCustomerPoints(customerId);
	    return Integer.valueOf(activeDay.getTotalPoints());
	}
	
	private int calculateTotalPoints(List<Product> products) { 		
		int totalRequiredPoints = 0;
		for (Product product : products){		
			totalRequiredPoints = totalRequiredPoints += product.getPointsCost();
		}
		
		return totalRequiredPoints;
	}
	 
	private boolean isSuffientPoints(int totalPointsRequired, int customerTotalPoints){
		logger.info("customer Total Points: " + customerTotalPoints + ", total Points Required:" + totalPointsRequired);
		if(customerTotalPoints >= totalPointsRequired){
			logger.info("customer has sufficient points");	
		}else if(customerTotalPoints < totalPointsRequired){
			logger.info("customer does not have sufficient points");
		}
		return customerTotalPoints >= totalPointsRequired;
	}
	
	private List<String> getProductCodes(PurchaseRequest purchaseRequest) {
		List<String> productCodes = new ArrayList();		
		purchaseRequest.getProducts().stream()
									.filter(p -> p.getCode() != null)
									.forEach(filtered -> productCodes.add(filtered.getCode()));
		
		return productCodes;
	}
	
	private void processPurchase(PurchaseRequest purchaseRequest) {
		List<String> productCodes = getProductCodes(purchaseRequest);																					
		List<Product> products = findProductsByCodes(productCodes);		 
		int totalPointRequired = calculateTotalPoints(products);
		int customerTotalPoints = getTotalCustomerPoints(purchaseRequest.getCustomerId());		
		int balance = customerTotalPoints - totalPointRequired;
		
		ActiveDay activeDay = activeDayService.getTotalCustomerPoints(purchaseRequest.getCustomerId());
		activeDay.setTotalPoints(balance);
		activeDayService.updateCustomerPoints(activeDay);
	}
	


}

