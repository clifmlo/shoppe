package com.assessment.shoppe;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.assessment.shoppe.model.Customer;
import com.assessment.shoppe.service.CustomerService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTests {
	
	public CustomerServiceTests(){
		
	}
	
	@Mock
	private CustomerService customerService;
	
	@Test
	public void testFindCustomerById() {
		Mockito.when(customerService.findCustomerById(1)).thenReturn(new Customer(11, "Cliford Mlotshwa"));
		Customer customer = customerService.findCustomerById(1);
		assertNotNull(customer);
		assertEquals("Cliford Mlotshwa", customer.getName(), "Customer does not match Cliford Mlotshwa");
	}
}