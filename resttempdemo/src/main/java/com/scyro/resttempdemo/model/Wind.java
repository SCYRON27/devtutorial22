package com.scyro.resttempdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Wind {
	
	private double speed;
    private long deg;
    private double gust;

}
