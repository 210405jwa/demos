package com.revature.exceptions;

public class AddPirateException extends Exception {

	public AddPirateException() {
	}

	public AddPirateException(String message) {
		super(message);
	}

	public AddPirateException(Throwable cause) {
		super(cause);
	}

	public AddPirateException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddPirateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
