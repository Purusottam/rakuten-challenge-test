package com.purusottam.kafka.challenge.util;

import com.purusottam.kafka.challenge.model.TimedLocation;

public class GpxUtil {
	/* Radius of earth in kilometers */
	public static final double RADIUS = 6371;

	public static double getDistance(TimedLocation previous, TimedLocation current) {
		if (previous == null || current == null) {
			return 0;
		}
		return calculateDistance(previous.getLatitude(), current.getLatitude(), previous.getLongitude(),
				current.getLongitude());
	}

	public static double calculateDistance(double lat1, double lat2, double lon1, double lon2) {
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		/*
		 * Haversine formula to calculate distance between 2 points on earth based on
		 * their latitude-longitude values. 
		 * Reference:
		 * https://www.geeksforgeeks.org/program-distance-two-points-earth/
		 */
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return (c * RADIUS);
	}
}
