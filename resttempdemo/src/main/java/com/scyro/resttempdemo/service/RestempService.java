package com.scyro.resttempdemo.service;

import org.springframework.http.ResponseEntity;

import com.scyro.resttempdemo.exception.RestTempException;

public interface RestempService {

	public ResponseEntity<?> getWeather(String location) throws RestTempException;

}
