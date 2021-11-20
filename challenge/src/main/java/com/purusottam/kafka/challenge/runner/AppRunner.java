package com.purusottam.kafka.challenge.runner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.purusottam.kafka.challenge.util.CSVProcessor;

@Component
public class AppRunner implements CommandLineRunner {

	@Autowired
	CSVProcessor csvProcessor;
    
	@Override
	public void run(String... args) throws Exception {
		//for now, let's consider file is in the resources folder
		Resource resource = new ClassPathResource("cycle_gpx.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		csvProcessor.readData(reader);
	}
}
