package com.unsuccessful.us.exception;

public class UnSuccessfulRestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnSuccessfulRestException() {
		super();
	}
	
	public UnSuccessfulRestException(String message, Object obj) {
		super(message);
	}
	
}
