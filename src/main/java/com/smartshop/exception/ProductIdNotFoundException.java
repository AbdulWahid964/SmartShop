package com.smartshop.exception;

/**
 * @author Abdul
 *
 */

public class ProductIdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProductIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductIdNotFoundException(String message) {
		super(message);
	}

	public ProductIdNotFoundException(Throwable cause) {
		super(cause);
	}

}