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
			//System.out.println("Job Detail"+joblist.indexOf(job)+1);
			total = total+ Integer.parseInt(job.getPrice());
			//System.out.println(job.getPrice());
		}
		//System.out.println(joblist.toString());
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
			System.out.println("PRICE : "+pp);
			cost.setPrice(Integer.toString(pp));
		}
	}
	public  List<JobCostDetail> readDataFromFile(){
		String csvFile = "C:/Users/user/Downloads/papercut1/src/main/resources/sample.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int iteration=0;
		List<JobCostDetail> jobs = new ArrayList<JobCostDetail>();
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (iteration == 0) {
					iteration++;
					continue;
				}
				String[] ppaper = line.split(cvsSplitBy);
				jobs.add(new JobCostDetail(Integer.parseInt(ppaper[0]),Integer.parseInt(ppaper[1]),Boolean.parseBoolean(ppaper[2])));		
				//jobs.add(new JobCostDetail(ppaper[0],ppaper[1],Boolean.parseBoolean(ppaper[2])));
			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jobs;
	}
	
	public void getPriceDetails(){
		System.out.println(papercutRespository.findOne(1).toString());
	}
	
	public void addPriceDetails(PricingDetails pd){
		papercutRespository.save(pd);
	}
}
