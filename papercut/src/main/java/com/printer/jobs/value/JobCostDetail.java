package com.printer.jobs.value;

public class JobCostDetail extends IncomingJobDetail {
	
	private int bwPages;
	private String price;
	public int getBwPages() {
		return bwPages;
	}
	public void setBwPages(int bwPages) {
		this.bwPages = bwPages;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public JobCostDetail(int totalPages, int colorPages, boolean doubleSided) {
		super(totalPages, colorPages, doubleSided);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JobCostDetail [bwPages=" + bwPages + ", price=" + price + ", getTotalPages()=" + getTotalPages()
				+ ", isColorPages()=" + getColorPages() + ", isDoubleSided()=" + isDoubleSided() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
