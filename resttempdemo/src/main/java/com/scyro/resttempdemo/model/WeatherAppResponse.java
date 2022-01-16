package com.scyro.resttempdemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class WeatherAppResponse {
	
	@JsonProperty("city")
	private String cityName;
	
	@JsonProperty("country")
	private String countryCode;
	
	@JsonProperty("temperature")
	private String tempInCelsius;
	
	@JsonProperty("description")
	private String weatherDescription;
	
	
}
