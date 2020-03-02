package com.smartshop.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Abdul
 *
 */

@ControllerAdvice
public class CustomExceptionHandler {

	private static final Logger logger = LogManager.getLogger(CustomExceptionHandler.class);

	/* Author Abdul Wahid for Resource Not Found Exception */
/*	@ExceptionHandler
	public ResponseEntity<ResourceResponseError> resourceHandlerMethod(ResourceNotFoundException exception) {

		logger.info("Exception Caught " + exception.getMessage());

		ResourceResponseError error = new ResourceResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<ResourceResponseError>(error, HttpStatus.BAD_REQUEST);
	}*/

	/* Author Abdul Wahid for Database Authentication Error */
	@ExceptionHandler
	public ResponseEntity<ResourceResponseError> databaseAuthenticationHandlerMethod(
			DatabaseAuthenticationException exception) {

		logger.info("Exception Caught " + exception.getMessage());

		ResourceResponseError error = new ResourceResponseError();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<ResourceResponseError>(error, HttpStatus.BAD_REQUEST);
	}

	/* Author Abdul Wahid for ProductId Not Found Exception */
	@ExceptionHandler
	public ResponseEntity<ResourceResponseError> objectIdHandlerMethod(ProductIdNotFoundException exception) {

		logger.info("Exception Caught " + exception.getMessage());

		ResourceResponseError error = new ResourceResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<ResourceResponseError>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ModelAndView resourceHandlerMethod(ResourceNotFoundException exception) {

		logger.info("Exception Caught " + exception.getMessage());

		ResourceResponseError error = new ResourceResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		error.setMessage(exception.getMessage());
		return new ModelAndView("error-page","error",error);
	}
}
