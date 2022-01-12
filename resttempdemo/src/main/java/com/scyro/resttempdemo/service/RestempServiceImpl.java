package com.scyro.resttempdemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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
	public CustomResponse getWeather(String location) throws RestTempException {

		return getFinalResponse(location);
	}

	@Override
	public CustomResponse getFinalResponse(String location) throws RestTempException {

		ResponseEntity<WeatherAPIResponse> response = getResponseWeatherAPI(location);

		log.info("Response from weather API: - " + response.getBody().toString());

		return getUpdatedResponse(response);

	}

	@Override
	public ResponseEntity<WeatherAPIResponse> getResponseWeatherAPI(String location) throws RestTempException {

		Map<String, String> uriVariables = new HashMap<>();

		uriVariables.put(Consts.cityName, location);
		uriVariables.put(Consts.APIKey, Consts.APIKeyValue);

		try {
			return restTemplate.exchange(Consts.WeatherAPIURL, HttpMethod.GET, null, WeatherAPIResponse.class,
					uriVariables);
		} catch (Exception exc) {
			throw new RestTempException("Not a valid city. Please provide valid city");
		}

	}

	@Override
	public CustomResponse getUpdatedResponse(ResponseEntity<WeatherAPIResponse> responseWeather) {

		CustomResponse customResponse = new CustomResponse();

		customResponse.setCityName(responseWeather.getBody().getName());
		customResponse.setCountryCode(responseWeather.getBody().getSys().getCountry());
		customResponse.setTempInCelsius(
				String.format("%.2f", responseWeather.getBody().getMain().getTemp() - 273.15) + " °C");
		customResponse.setWeatherDescription(responseWeather.getBody().getWeather().get(0).getDescription());

		log.info("Response to User:- " + customResponse);

		return customResponse;

	}

}
