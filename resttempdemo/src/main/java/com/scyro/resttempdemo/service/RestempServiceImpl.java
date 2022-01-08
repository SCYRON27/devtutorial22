package com.scyro.resttempdemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scyro.resttempdemo.model.Airline;
import com.scyro.resttempdemo.model.WeatherResponse;

@Service
public class RestempServiceImpl implements RestempService {

	@Autowired
	private RestTemplate restTemplate;
/*
	@Override
	public ResponseEntity<?> getDetails(String id) {

		String url = "https://api.instantwebtools.net/v1/airlines/{id}";

		ResponseEntity<Airline> response = restTemplate.exchange(url, HttpMethod.GET, null, Airline.class, id);

		return response;
	}

	@Override
	public ResponseEntity<?> getAirlines() {

		String result = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);

		String url = "https://api.instantwebtools.net/v1/airlines";

		ResponseEntity<Airline[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Airline[].class);

		Airline[] airlines = response.getBody();

		try {
			result = mapper.writeValueAsString(airlines);
			return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Not getting a valid response", HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}
*/
	@Override
	public ResponseEntity<?> getWeather(String location) {

		String url = "https://api.openweathermap.org/data/2.5/weather?q={city_id}&appid={API_key}";
		
		Map<String, String> uriVariables = new HashMap<>();
		
		
		uriVariables.put("city_id", location);
		uriVariables.put("API_key", "7a5a38723eeb35e627d650dcaf6b4642");
		
		ResponseEntity<WeatherResponse> response = restTemplate.exchange(url, HttpMethod.GET,null,WeatherResponse.class,uriVariables);
		
		System.out.println(response.getBody().getCoord().getLat());
		System.out.println(response.getBody().getCoord().getLon());
		
		return response;
	}

}
