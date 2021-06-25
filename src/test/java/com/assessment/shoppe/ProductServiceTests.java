package com.assessment.shoppe;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.assessment.shoppe.model.Product;
import com.assessment.shoppe.service.ProductService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTests {
	
	public ProductServiceTests(){
		
	}
	
	@Mock
	private ProductService productService;
	
	@Test
	public void testfindAll() {
		Mockito.when(productService.findAll()).thenReturn(getProducts());
		List<Product> products = productService.findAll();
		assertNotNull(products);
		assertEquals(3, products.size(), " Product size not 3");			
	}
	
	@Test
	public void testfindProductByCode() {
		Mockito.when(productService.findProductByCode("TS6544")).thenReturn(new Product(1,"Ipad","TS6544",120));
		Product product = productService.findProductByCode("TS6544");
		assertNotNull(product);
		assertEquals("TS6544", product.getCode(), "Product code does not match");
	}

	private List<Product> getProducts(){
		Product product1 = new Product(1,"Acer Laptop","ACG001", 30);
		Product product2 = new Product(2,"Sumsung phone","PG660", 50);
		Product product3 = new Product(3,"Microwave","AT200", 75);
		
		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
	
	    return products;
    }
}