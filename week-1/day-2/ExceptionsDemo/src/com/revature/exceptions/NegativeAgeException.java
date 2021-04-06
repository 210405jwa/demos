package com.revature.exceptions;

// This is a checked exception because it extends directly from Exception
public class NegativeAgeException extends Exception {

	public NegativeAgeException() {
		super();
	}

	public NegativeAgeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NegativeAgeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegativeAgeException(String message) {
		super(message);
	}

	public NegativeAgeException(Throwable cause) {
		super(cause);
	}

}
