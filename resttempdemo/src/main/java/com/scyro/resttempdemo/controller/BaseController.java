package com.scyro.resttempdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scyro.resttempdemo.exception.RestTempException;
import com.scyro.resttempdemo.service.RestempService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/restemp")
@Slf4j
public class BaseController {
	
	@Autowired
	private RestempService restempService;

	@GetMapping("/fetchweather")
	public ResponseEntity<?> getWeather(@RequestParam String location) throws RestTempException{
		log.info("Request param received:-  " +location);
		
		
		if(!location.isEmpty()) {
			return restempService.getWeather(location);
		}
		else {
			throw new RestTempException("Location field cannot be empty");
			
		}
		
		
		
	}

}
