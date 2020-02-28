package com.smartshop.exception;

/**
 * @author Abdul
 *
 */
public class DatabaseAuthenticationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DatabaseAuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatabaseAuthenticationException(String message) {
		super(message);
	}

	public DatabaseAuthenticationException(Throwable cause) {
		super(cause);
	}

}