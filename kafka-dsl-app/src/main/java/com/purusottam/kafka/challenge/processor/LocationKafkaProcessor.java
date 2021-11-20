package com.purusottam.kafka.challenge.processor;

import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.purusottam.kafka.challenge.model.TimedLocation;
import com.purusottam.kafka.challenge.util.GpxUtil;

@Configuration
public class LocationKafkaProcessor {
	private Logger log = LoggerFactory.getLogger(LocationKafkaProcessor.class);

	TimedLocation previousLocation;
	double distance = 0;
	
	@Bean
	public Consumer<KStream<String, TimedLocation>> locationProcessor() {
		
		return kstream -> kstream.foreach((key, currentLocation) -> {
			//line separator, just to get a clear view the console log
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			log.info("## Location reached: Location[latitude:{}, longitude:{}] at time {}", currentLocation.getLatitude(), currentLocation.getLongitude(), currentLocation.getTime());
			if (previousLocation != null) {
				double stepDistance = GpxUtil.getDistance(previousLocation, currentLocation);
				log.info("## Distance from previous location: {} km", stepDistance);
				distance += stepDistance;
				log.info("## Distance covered so far: {} km at time: {}", distance, currentLocation.getTime());
			}
			previousLocation = currentLocation;
		});
	}
}