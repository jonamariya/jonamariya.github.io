package com.printer.jobs.service;

import com.printer.jobs.value.IncomingJobDetail;
import com.printer.jobs.value.JobCostDetail;

public class PreProcessor {
	public void calculatePrice(IncomingJobDetail job){
		JobCostDetail cost = (JobCostDetail) job;
	}
}
