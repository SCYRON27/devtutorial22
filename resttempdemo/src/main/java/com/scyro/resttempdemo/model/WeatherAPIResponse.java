package com.scyro.resttempdemo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class WeatherAPIResponse {

	private Coordinates coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private long visibility;
	private Wind wind;
	private Clouds clouds;
	private Rain rain;
	private Snow snow;
	private long dt;
	private Sys sys;
	private long timezone;
	private long id;
	private String name;
	private long cod;

}
