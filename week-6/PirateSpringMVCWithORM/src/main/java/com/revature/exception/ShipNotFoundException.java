package com.revature.exception;

public class ShipNotFoundException extends Exception {

	public ShipNotFoundException() {
	}

	public ShipNotFoundException(String arg0) {
		super(arg0);
	}

	public ShipNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public ShipNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShipNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
