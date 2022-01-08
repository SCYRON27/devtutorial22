package com.scyro.resttempdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {

	private long id;
	private String main;
	private String description;
	private String icon;

}
