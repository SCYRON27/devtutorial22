package com.scyro.resttempdemo.service;

import org.springframework.http.ResponseEntity;

import com.scyro.resttempdemo.exception.RestTempException;
import com.scyro.resttempdemo.model.CustomResponse;
import com.scyro.resttempdemo.model.WeatherAPIResponse;

public interface RestempService {

	public CustomResponse getWeather(String location) throws RestTempException;
	
	public CustomResponse getFinalResponse(String location) throws RestTempException;
	
	public ResponseEntity<WeatherAPIResponse> getResponseWeatherAPI(String location) throws RestTempException;
	
	public CustomResponse getUpdatedResponse(ResponseEntity<WeatherAPIResponse> responseWeather);

}
