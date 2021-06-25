package com.assessment.shoppe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ActiveDay {
	
	@Id
	@GeneratedValue
	private int id;
	private int  customerId;
	private int  activeDays;
	private int  totalPoints;
	
	public ActiveDay(){
		
	}
	
	public ActiveDay(int id, int customerId, int activeDays, int totalPoints) {		
		this.id = id;
		this.customerId = customerId;
		this.activeDays = activeDays;
		this.totalPoints = totalPoints;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getActiveDays() {
		return activeDays;
	}
	public void setActiveDays(int activeDays) {
		this.activeDays = activeDays;
	}
	public int getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	public String toString() {
		return "ActiveDay [id=" + id + ", customerId=" + customerId
				+ ", activeDays=" + activeDays + ", totalPoints=" + totalPoints
				+ "]";
	}
	
}


