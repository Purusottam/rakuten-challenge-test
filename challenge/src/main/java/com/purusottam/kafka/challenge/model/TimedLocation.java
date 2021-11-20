package com.purusottam.kafka.challenge.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimedLocation implements Serializable {
	
	private static final long serialVersionUID = 6569374778681485852L;

	private double latitude;
	private double longitude;
	private LocalDateTime time;
}
