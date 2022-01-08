package com.scyro.resttempdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rain {

	@JsonProperty("1h")
	private double _1h;
	@JsonProperty("3h")
	private double _3h;
}
