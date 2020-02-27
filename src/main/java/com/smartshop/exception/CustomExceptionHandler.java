package com.smartshop.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	private static final Logger logger = LogManager.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler
	public ResponseEntity<ResourceResponseError> handlerMethod(ResourceNotFoundException exception) {

		logger.info("Exception Caught " + exception.getMessage());

		ResourceResponseError error = new ResourceResponseError();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<ResourceResponseError>(error, HttpStatus.BAD_REQUEST);
	}

}
