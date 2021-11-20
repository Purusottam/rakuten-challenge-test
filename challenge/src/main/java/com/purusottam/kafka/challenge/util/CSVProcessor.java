package com.purusottam.kafka.challenge.util;

import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.purusottam.kafka.challenge.model.TimedLocation;
import com.purusottam.kafka.challenge.producer.Producer;

@Component
public class CSVProcessor {

	private Logger log = LoggerFactory.getLogger(CSVProcessor.class);

	@Autowired
	Producer kafkaProducer;

	public void readData(Reader reader) {
		try (CSVReader csvReader = new CSVReader(reader)) {
			String[] nextLine;
			// read one line at a time
			while ((nextLine = csvReader.readNext()) != null) {
				TimedLocation locationWithTime = getTimedLocation(nextLine);
				//log.info("## data read from csv in object format: {}", locationWithTime);
				kafkaProducer.publishData(locationWithTime);
				Thread.sleep(200);
			}
		} catch (IOException fnex) {
			fnex.printStackTrace();
		} catch (CsvValidationException cvex) {
			cvex.printStackTrace();
		} catch (InterruptedException iex) {
			iex.printStackTrace();
		}
	}

	public static TimedLocation getTimedLocation(String[] rowData) {
		double latitude = Double.parseDouble(rowData[0]);
		double longitude = Double.parseDouble(rowData[1]);
		// for location time, consider the current system time like hh:mm:ss 
		LocalTime now = LocalTime.now();
		return new TimedLocation(latitude, longitude,
				LocalDateTime.of(LocalDate.now(), LocalTime.of(now.getHour(), now.getMinute(), now.getSecond())));
	}
}
