package com.scyro.resttempdemo.service;

import org.springframework.http.ResponseEntity;

import com.scyro.resttempdemo.exception.RestTempException;
import com.scyro.resttempdemo.model.WeatherAppResponse;
import com.scyro.resttempdemo.model.WeatherAPIResponse;

public interface RestempService {

	public WeatherAppResponse getWeather(String location) throws RestTempException;
	
	public WeatherAppResponse getFinalResponse(String location) throws RestTempException;
	
	public ResponseEntity<WeatherAPIResponse> getResponseWeatherAPI(String location) throws RestTempException;
	
	public WeatherAppResponse getUpdatedResponse(ResponseEntity<WeatherAPIResponse> responseWeather);

}
