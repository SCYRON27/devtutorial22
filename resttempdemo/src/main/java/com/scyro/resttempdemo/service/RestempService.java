package com.scyro.resttempdemo.service;

import org.springframework.http.ResponseEntity;

import com.scyro.resttempdemo.exception.RestTempException;
import com.scyro.resttempdemo.model.CustomResponse;

public interface RestempService {

	public ResponseEntity<CustomResponse> getWeather(String location) throws RestTempException;

}
