package com.printer.jobs.value;

import java.util.Collection;

public class TotalJobs {
	private int totalCost;
	private Collection<JobCostDetail> jobsList;
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public Collection<JobCostDetail> getJobsList() {
		return jobsList;
	}
	public void setJobsList(Collection<JobCostDetail> jobsList) {
		this.jobsList = jobsList;
	}
	@Override
	public String toString() {
		return "TotalJobs [totalCost=" + totalCost + ", jobsList=" + jobsList + "]";
	}
	
	
}
