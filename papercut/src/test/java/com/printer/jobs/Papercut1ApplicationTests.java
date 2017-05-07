package com.printer.jobs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.printer.jobs.models.PricingDetails;
import com.printer.jobs.service.PapercutService;
import com.printer.jobs.value.JobCostDetail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Papercut1ApplicationTests {
	@Autowired
	PapercutService papercutService; 
	@Test
	public void contextLoads() {
		//addNewPricing();
		getEstimates();
	}

	public void getEstimates(){
		List<JobCostDetail> joblist = new ArrayList();
		papercutService.getEstimates();
	}
	public void addNewPricing(){
		PricingDetails pd =new PricingDetails("A4", false, false, 15);
		papercutService.addPriceDetails(pd);
		pd =new PricingDetails("A4", true, false, 25);
		papercutService.addPriceDetails(pd);
		pd =new PricingDetails("A4", false, true, 10);
		papercutService.addPriceDetails(pd);
		pd =new PricingDetails("A4", true, true, 20);
		papercutService.addPriceDetails(pd);
	}
}
