package com.printer.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.printer.jobs.service.PapercutService;

@SpringBootApplication
public class PapercutApplication {
	public static void main(String[] args) {
		SpringApplication.run(PapercutApplication.class, args);
	}
}
