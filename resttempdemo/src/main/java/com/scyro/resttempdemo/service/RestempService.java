package com.scyro.resttempdemo.service;

import org.springframework.http.ResponseEntity;

public interface RestempService {
	/*
	 * public ResponseEntity<?> getDetails(String id);
	 * 
	 * public ResponseEntity<?> getAirlines();
	 */
	public ResponseEntity<?> getWeather(String location);

}
