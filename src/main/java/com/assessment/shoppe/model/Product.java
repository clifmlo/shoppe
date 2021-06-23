package com.assessment.shoppe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	private String  name;
	private String  code;
	private int  POINTS_COST;
	
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
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public int getPOINTS_COST() {
		return POINTS_COST;
	}
	
	public void setPOINTS_COST(int pOINTS_COST) {
		POINTS_COST = pOINTS_COST;
	}
	
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", code=" + code
				+ ", POINTS_COST=" + POINTS_COST + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getCode()=" + getCode()
				+ ", getPOINTS_COST()=" + getPOINTS_COST() + "]";
	}
}


