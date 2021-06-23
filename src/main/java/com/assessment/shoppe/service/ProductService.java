package com.assessment.shoppe.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.assessment.shoppe.model.Product;
import com.assessment.shoppe.repo.ProductRepository;

@Service
public class ProductService {
	Logger logger = LoggerFactory.getLogger(ProductService.class);
    
	@Autowired
	private ProductRepository productRepo;
	
	@Transactional(readOnly=true)
	public List<Product> findAll(){
		List<Product>  products  = new ArrayList();
		
		try{		
			products = (List<Product>) productRepo.findAll();
			logger.info("products result size: " + products.size());
		}catch (Exception e){
			e.printStackTrace();			
		}
		
		return products;
	}
	
	public Product findProductById(int id){
		return productRepo.getById(id);
	}
	
	public Product findProductByCode(String code){
		return productRepo.getByCode(code);
	}
}
