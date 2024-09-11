package com.unsuccessful.us.exception;

public class InvalidEmailException extends RuntimeException{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmailException(String message) {
	        super(message);
	    }

	public InvalidEmailException() {
		super();
	}
	
	public InvalidEmailException(Object obj) {
		super();
	}

}
