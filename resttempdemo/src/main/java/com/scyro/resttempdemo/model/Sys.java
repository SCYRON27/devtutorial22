package com.scyro.resttempdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sys {

	private long type;
	private long id;
	private String message;
	private String country;
	private long sunrise;
	private long sunset;

}
