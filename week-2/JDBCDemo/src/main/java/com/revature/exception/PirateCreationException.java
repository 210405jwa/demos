package com.revature.exception;

public class PirateCreationException extends Exception {

	public PirateCreationException() {
	}

	public PirateCreationException(String message) {
		super(message);
	}

	public PirateCreationException(Throwable cause) {
		super(cause);
	}

	public PirateCreationException(String message, Throwable cause) {
		super(message, cause);
	}

	public PirateCreationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
