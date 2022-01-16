package com.scyro.resttempdemo.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String message;
	private int status;

}
