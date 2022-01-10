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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scyro.resttempdemo.exception.RestTempException;
import com.scyro.resttempdemo.model.WeatherAPIResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestempServiceImpl implements RestempService {

	@Autowired
	private RestTemplate restTemplate;
	

	@Override
	public ResponseEntity<?> getWeather(String location) throws RestTempException {
		
		String result = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		String url = "https://api.openweathermap.org/data/2.5/weather?q={city_id}&appid={API_key}";
		
		Map<String, String> uriVariables = new HashMap<>();
		
		
		uriVariables.put("city_id", location);
		uriVariables.put("API_key", "7a5a38723eeb35e627d650dcaf6b4642");
		
		
		ResponseEntity<WeatherAPIResponse> response;
		try {
			response = restTemplate.exchange(url, HttpMethod.GET,null,WeatherAPIResponse.class,uriVariables);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new RestTempException("Not a valid city. Please provide valid city");
		}
//		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,null,String.class,uriVariables);
		
		
		System.out.println(response.getBody());
		
		try {
			result = mapper.writeValueAsString(response.getBody());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<String>(result,responseHeaders,HttpStatus.OK);
	}

}
