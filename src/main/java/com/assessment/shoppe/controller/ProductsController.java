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
import com.assessment.shoppe.util.PurchaseRequest;
import com.assessment.shoppe.util.ResponseObject;
import com.assessment.shoppe.model.Customer;
import com.assessment.shoppe.model.Product;


@RestController
@RequestMapping("/product")
public class ProductsController {
	Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return productService.findAll();		
	}
	
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public ResponseEntity purchase(@RequestBody PurchaseRequest purchaseRequest) {		
		logger.info("Received request: " + purchaseRequest.toString());
		
		ResponseObject response = new ResponseObject(); 
		List<Product> nonExistentProducts = new ArrayList();
				
		if(!customerExists(purchaseRequest.getCustomerId())){	//The customer ID does not exist		
			response.setResultCode("1");
			response.setResultMsg("Purchase Failed. Customer Does not Exist.");			
			
			return new ResponseEntity<>(response, HttpStatus.OK);			
		}
		
		if(purchaseRequest.getProducts() != null && purchaseRequest.getProducts().isEmpty()){ //The customer did not provide any products to purchase
			response.setResultCode("1");
			response.setResultMsg("Purchase Failed. No products provided for purchase.");			
			
			return new ResponseEntity<>(response, HttpStatus.OK);				
		}
		
		if(purchaseRequest.getProducts() != null){
			nonExistentProducts = productsExist(purchaseRequest.getProducts());
		}
				
		if(!nonExistentProducts.isEmpty()){ //The customer chose non-existent product(s) code
			List<String> nonExistentProductCodes = new ArrayList();
			nonExistentProducts.forEach(p -> nonExistentProductCodes.add(p.getCode()));
			response.setResultCode("1");
			response.setResultMsg("Purchase Failed. The following poduct code(s) were not found: " + nonExistentProductCodes.toString());	
			
			return new ResponseEntity<>(response, HttpStatus.OK);		
		}

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
}

