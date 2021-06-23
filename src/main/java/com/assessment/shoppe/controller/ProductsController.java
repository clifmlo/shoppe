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
import com.assessment.shoppe.util.PurchaseRequest;
import com.assessment.shoppe.model.Product;


@RestController
@RequestMapping("/product")
public class ProductsController {
	Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return productService.findAll();		
	}
	
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public ResponseEntity purchaseWithId(@RequestBody PurchaseRequest purchaseRequest) {
		
		//The customer ID does not exist
		if(){
			
		}
		
		//The customer does not have enough points
		if(){
			
		}

		//The customer did not provide any products to purchase
		if(){
			
		}
		
		//The customer chose a non-existent product code
		if(){
			
		}
			
	}
	
	private boolean existProduct(Product product){
		return findProductById(product.getId()) != null || findProductByCode(product.getCode())  != null;
	}
	
	private Product findProductById(int id){
		return productService.findProductById(id);
	}
	
	private Product findProductByCode(String code){
		return productService.findProductByCode(code);
	}

}

