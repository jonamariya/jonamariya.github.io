package com.printer.jobs.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import com.printer.jobs.models.PricingDetails;
import com.printer.jobs.repository.PapercutRepository;
import com.printer.jobs.value.IncomingJobDetail;
import com.printer.jobs.value.JobCostDetail;
import com.printer.jobs.value.TotalJobs;

@Service
public class PapercutService {
	@Autowired
	PapercutRepository papercutRespository;
	public TotalJobs getEstimates(){	

		TotalJobs totalJ = new TotalJobs();
		List<JobCostDetail> joblist = readDataFromFile();
		int total=0;
		for (JobCostDetail job : joblist ){
			calculatePricePerJob(job);
			//total = total+ Integer.parseInt(job.getPrice());
			System.out.println(job.getPrice());
		}
		System.out.println(joblist.toString());
		totalJ.setJobsList(joblist);
		totalJ.setTotalCost(total);
		System.out.println(totalJ.toString());
		return totalJ;
	}
	public void calculatePricePerJob(JobCostDetail job){
		JobCostDetail cost = (JobCostDetail) job;
		cost.setBwPages(job.getTotalPages()-job.getColorPages());
		System.out.println("before query");
		List<PricingDetails> lis = papercutRespository.findByDoubleSidedAndSize(job.isDoubleSided(),"A4");
		int colorPrice=0;
		int bwPrice=0;
		int pp =0;
		for(PricingDetails det : lis){
			if(det.isColor()){
				colorPrice = det.getPrice();
			}else{
				bwPrice=det.getPrice();
			}
		}
		if(colorPrice!=0 && bwPrice!=0){
			pp=(cost.getColorPages()*colorPrice)+(cost.getBwPages()*bwPrice);
			cost.setPrice(Integer.toString(pp));
		}
	}
	public  List<JobCostDetail> readDataFromFile(){
		List<JobCostDetail> jobs = new ArrayList<JobCostDetail>();
		
		jobs.add(new JobCostDetail(25,10,false));
		jobs.add(new JobCostDetail(55,13,true));
		return jobs;
	}
	
	public void getPriceDetails(){
		System.out.println(papercutRespository.findOne(1).toString());
	}
	
	public void addPriceDetails(PricingDetails pd){
		papercutRespository.save(pd);
	}
}
