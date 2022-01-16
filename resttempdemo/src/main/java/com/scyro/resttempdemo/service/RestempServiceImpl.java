package com.scyro.resttempdemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scyro.resttempdemo.exception.RestTempException;
import com.scyro.resttempdemo.model.WeatherAppResponse;
import com.scyro.resttempdemo.model.WeatherAPIResponse;
import com.scyro.resttempdemo.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestempServiceImpl implements RestempService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public WeatherAppResponse getWeather(String location) throws RestTempException {

		return getFinalResponse(location);
	}

	@Override
	public WeatherAppResponse getFinalResponse(String location) throws RestTempException {

		ResponseEntity<WeatherAPIResponse> response = getResponseWeatherAPI(location);

		log.info("Response from weather API: - " + response.getBody().toString());

		return getUpdatedResponse(response);

	}

	@Override
	public ResponseEntity<WeatherAPIResponse> getResponseWeatherAPI(String location) throws RestTempException {

		Map<String, String> uriVariables = new HashMap<>();

		uriVariables.put(Constants.CITY_NAME, location);
		uriVariables.put(Constants.API_KEY, Constants.API_KEY_VALUE);

		try {
			return restTemplate.exchange(Constants.WEATHER_API_URL, HttpMethod.GET, null, WeatherAPIResponse.class,
					uriVariables);
		} catch (Exception exc) {
			throw new RestTempException("Not a valid city. Please provide valid city");
		}

	}

	@Override
	public WeatherAppResponse getUpdatedResponse(ResponseEntity<WeatherAPIResponse> responseWeather) {

		WeatherAppResponse customResponse = new WeatherAppResponse();

		customResponse.setCityName(responseWeather.getBody().getName());
		customResponse.setCountryCode(responseWeather.getBody().getSys().getCountry());
		customResponse.setTempInCelsius(
				String.format("%.2f", responseWeather.getBody().getMain().getTemp() - 273.15) + " °C");
		customResponse.setWeatherDescription(responseWeather.getBody().getWeather().get(0).getDescription());

		log.info("Response to User:- " + customResponse);

		return customResponse;

	}

}
