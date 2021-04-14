package com.revature.exceptions;

public class PirateNotFoundException extends Exception {

	public PirateNotFoundException() {
		super();
	}

	public PirateNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PirateNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PirateNotFoundException(String message) {
		super(message);
	}

	public PirateNotFoundException(Throwable cause) {
		super(cause);
	}

}
