package com.scyro.resttempdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Main {

	private double temp;
	private double feels_like;
	private double temp_min;
	private double temp_max;
	private long pressure;
	private long humidity;
	private long sea_level;
	private long grnd_level;

}
