package com.printer.jobs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.printer.jobs.models.PricingDetails;
import com.printer.jobs.service.PapercutService;
import com.printer.jobs.value.IncomingJobDetail;
import com.printer.jobs.value.JobCostDetail;
import com.printer.jobs.value.TotalJobs;

@RestController
public class RequestController {
	@Autowired
	PapercutService papercutService;
	@RequestMapping(value="/papercutjobs",method=RequestMethod.GET)
	public TotalJobs getEstimates(){
		
		return (papercutService.getEstimates());
	}
	
	@RequestMapping(value="/papercutjobs",method=RequestMethod.POST)
	public void addPriceDetails(PricingDetails pd){
		papercutService.addPriceDetails(pd);
	}
}
