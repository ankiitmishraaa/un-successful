package com.unsuccessful.us.exception;

public class InvalidRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
	
	public InvalidRequestException(String message) {
		super(message);
	}
	
	public InvalidRequestException() {
		super();
	}
	
	public InvalidRequestException(String message, Object obj) {
		super(message, (Throwable) obj);
		this.message = message;
	}
	
	public InvalidRequestException(Object obj) {
		super();
	}

}
