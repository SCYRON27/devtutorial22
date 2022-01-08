package com.scyro.resttempdemo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface RestempService {
	
	public ResponseEntity<?> getDetails(String id);
	
	public ResponseEntity<?> getAirlines();
	
	public ResponseEntity<?> getWeather(String location);

}
