package com.scyro.resttempdemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scyro.resttempdemo.exception.RestTempException;
import com.scyro.resttempdemo.model.CustomResponse;
import com.scyro.resttempdemo.model.WeatherAPIResponse;
import com.scyro.resttempdemo.util.Consts;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestempServiceImpl implements RestempService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<CustomResponse> getWeather(String location) throws RestTempException {

		CustomResponse customResponse = new CustomResponse();


		Map<String, String> uriVariables = new HashMap<>();

		uriVariables.put(Consts.cityName, location);
		uriVariables.put(Consts.APIKey, Consts.APIKeyValue);

		ResponseEntity<WeatherAPIResponse> response;
		try {
			response = restTemplate.exchange(Consts.WeatherAPIURL, HttpMethod.GET, null, WeatherAPIResponse.class, uriVariables);
			log.info("Response from weather API: - " + response.getBody().toString());
			
			
			customResponse.setCityName(response.getBody().getName());
			customResponse.setCountryCode(response.getBody().getSys().getCountry());
			customResponse.setTempInCelsius(String.format("%.2f",response.getBody().getMain().getTemp() - 273.15) + " °C");
			customResponse.setWeatherDescription(response.getBody().getWeather().get(0).getDescription());
			
			log.info("Response to User:- "+customResponse);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new RestTempException("Not a valid city. Please provide valid city");
		}

		return new ResponseEntity<CustomResponse>(customResponse,HttpStatus.OK);
	}

}
