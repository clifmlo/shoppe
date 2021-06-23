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
		try{		
			List<Product> products = (List<Product>) productRepo.findAll();
			
			if(products != null){
				logger.info("products result size: " + products.size());
			}else{
				logger.info("No products found.");
			}
			return products;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public Product findProductByCode(String code){		
		try{		
			Product product = productRepo.getByCode(code);
			if(product != null){
				logger.info("returned product: " + product.toString());
			}else{
				logger.info("No product found.");
			}	
			return product;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}		
	}
}
