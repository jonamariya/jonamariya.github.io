package com.printer.jobs.value;

public class IncomingJobDetail {

	private int totalPages;
	private int colorPages;
	private boolean doubleSided;
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getColorPages() {
		return colorPages;
	}
	public void setColorPages(int colorPages) {
		this.colorPages = colorPages;
	}
	public boolean isDoubleSided() {
		return doubleSided;
	}
	public void setDoubleSided(boolean doubleSided) {
		this.doubleSided = doubleSided;
	}
	public IncomingJobDetail(int totalPages, int colorPages, boolean doubleSided) {
		super();
		this.totalPages = totalPages;
		this.colorPages = colorPages;
		this.doubleSided = doubleSided;
	}
	


	
	
}
