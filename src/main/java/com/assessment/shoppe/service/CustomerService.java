package com.assessment.shoppe.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.assessment.shoppe.model.Customer;
import com.assessment.shoppe.repo.CustomerRepository;

@Service
public class CustomerService {
	Logger logger = LoggerFactory.getLogger(CustomerService.class);
    
	@Autowired
	private CustomerRepository customerRepo;
	
	@Transactional(readOnly=true)
	public Customer findCustomerById(int id){
		
		try{		
			Customer customer = customerRepo.getById(id);
			if(customer != null){
				logger.info("returned customer id : " + customer.getId()); 
			}else{
				logger.info("Customer not found.");
			}
			
			return customer;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
