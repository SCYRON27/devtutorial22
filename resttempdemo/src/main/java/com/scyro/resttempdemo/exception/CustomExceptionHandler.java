package com.scyro.resttempdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RestTempException.class)
	public ResponseEntity<ErrorResponse> customHandler(Exception ex) {

		ex.printStackTrace();
		ErrorResponse error = new ErrorResponse();

		error.setMessage(ex.getMessage());
		error.setStatus(500);

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
