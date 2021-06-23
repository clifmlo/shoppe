package com.assessment.shoppe.util;

import java.util.List;

import com.assessment.shoppe.model.Product;


public class PurchaseRequest {

	private int customerId;
	private List<Product> products;
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}


