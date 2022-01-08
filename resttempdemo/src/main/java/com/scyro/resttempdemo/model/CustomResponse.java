package com.scyro.resttempdemo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomResponse{
	
	
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
