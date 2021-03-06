package com.assessment.shoppe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	private String  name;
	
	public Customer(){
		
	}
	
	public Customer(int id, String name) {		
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", getId()=" + getId()
				+ ", getName()=" + getName() + "]";
	}
	
}


