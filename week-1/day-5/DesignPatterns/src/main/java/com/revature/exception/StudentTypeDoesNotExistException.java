package com.revature.exception;

public class StudentTypeDoesNotExistException extends RuntimeException {

	public StudentTypeDoesNotExistException() {
		super();
	}

	public StudentTypeDoesNotExistException(String message) {
		super(message);
	}

	public StudentTypeDoesNotExistException(Throwable cause) {
		super(cause);
	}

	public StudentTypeDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentTypeDoesNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
