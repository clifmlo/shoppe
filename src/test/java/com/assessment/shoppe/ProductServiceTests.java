//package com.assessment.shoppe;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.assessment.shoppe.model.Product;
//import com.assessment.shoppe.service.ProductService;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
////@RunWith(MockitoJUnitRunner.class)
//class ProductServiceTests {
//	@Mock()
//	@Autowired
//	private ProductService productService;
//	
////	@Test
////	public void testGetAllProducts() {
////		when(productService.findAll()).ThenReturn(getProducts());
////		List<Product> products = productService.findAll();
////		assertEquals(3, products.size());
////	}
//	
//	@Test
//	public void whenAssertingEquality_thenEqual() {
//	    String expected = "Baeldung";
//	    String actual = "Baeldung";
//
//	    assertEquals(expected, actual);
//	}
//	
//	private List<Product> getProducts(){
//		Product product1 = new Product(1,"Acer Laptop","ACG001", 30);
//		Product product2 = new Product(2,"Sumsung phone","PG660", 50);
//		Product product3 = new Product(3,"Microwave","AT200", 75);
//		
//		List<Product> products = new ArrayList<>();
//		products.add(product1);
//		products.add(product2);
//		products.add(product3);
//		
//		return products;
//	}
//
//}
