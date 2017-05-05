package com.printer.jobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PricingDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int priceId;
	private String size;
	private boolean color;
	private boolean doubleSided;
	private int price;
	public int getPriceId() {
		return priceId;
	}
	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	public boolean isDoubleSided() {
		return doubleSided;
	}
	public void setDoubleSided(boolean doubleSided) {
		this.doubleSided = doubleSided;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "PricingDetails [priceId=" + priceId + ", size=" + size + ", color=" + color + ", doubleSided="
				+ doubleSided + ", price=" + price + "]";
	}
	public PricingDetails(){};
	public PricingDetails(String size, boolean color, boolean doubleSided, int price) {
		super();
		this.size = size;
		this.color = color;
		this.doubleSided = doubleSided;
		this.price = price;
	}
	
}
