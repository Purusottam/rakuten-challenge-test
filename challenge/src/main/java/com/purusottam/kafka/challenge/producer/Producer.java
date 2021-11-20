package com.purusottam.kafka.challenge.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.purusottam.kafka.challenge.model.TimedLocation;

@Component
public class Producer {

	private Logger log = LoggerFactory.getLogger(Producer.class);

	@Value("${spring.kafka.template.default-topic}")
	private String topic;

	@Autowired
	private KafkaTemplate<String, TimedLocation> template;

	public void publishData(TimedLocation timedLocation) {
		//log.info("#####* Producer published data: {}", timedLocation);
		template.send(topic, timedLocation);
	}
}