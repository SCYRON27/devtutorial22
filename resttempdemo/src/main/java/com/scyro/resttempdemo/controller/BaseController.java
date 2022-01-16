package com.scyro.resttempdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scyro.resttempdemo.exception.RestTempException;
import com.scyro.resttempdemo.model.WeatherAppResponse;
import com.scyro.resttempdemo.service.RestempService;
import com.scyro.resttempdemo.util.Constants;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(Constants.BASE_URL)
@Slf4j
public class BaseController {

	@Autowired
	private RestempService restempService;

	@GetMapping(Constants.FETCH_WEATHER)
	public ResponseEntity<WeatherAppResponse> getWeather(@RequestParam String location) throws RestTempException {
		log.info("Request param received:-  " + location);

		if (!location.isEmpty()) {
			WeatherAppResponse customResponse = restempService.getWeather(location);
			return new ResponseEntity<WeatherAppResponse>(customResponse, HttpStatus.OK);
		} else {
			throw new RestTempException("Location field cannot be empty");

		}

	}

}
