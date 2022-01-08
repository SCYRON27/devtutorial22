package com.scyro.resttempdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scyro.resttempdemo.service.RestempService;

@RestController
@RequestMapping("/restemp")
public class FirstController {
	
	@Autowired
	private RestempService restempService;
	
	@GetMapping("/test")
	public String test() {
		return "Producer API working";
	}
	
	@GetMapping("/fetchdetails/{id}")
	public ResponseEntity<?> getDetails(@PathVariable String id) {
		
		
		return restempService.getDetails(id);
		
	}
	
	@GetMapping("/fetchdetails")
	public ResponseEntity<?> getAirlines() {
		
		
		return restempService.getAirlines();
		
	}
	
	@GetMapping("/fetchweather")
	public ResponseEntity<?> getWeather(@RequestParam String location){
		
		
		return restempService.getWeather(location);
	}

}
