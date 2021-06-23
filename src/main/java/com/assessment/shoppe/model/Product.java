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
	private int  pointsCost;
	
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
	
	public int getPointsCost() {
		return pointsCost;
	}
	
	public void setPointsCost(int pointsCost) {
		this.pointsCost = pointsCost;
	}
	
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", code=" + code
				+ ", pointsCost=" + pointsCost + "]";
	}
}


