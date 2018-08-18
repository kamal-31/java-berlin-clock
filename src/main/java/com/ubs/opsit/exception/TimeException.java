package com.ubs.opsit.exception;

public class TimeException extends RuntimeException {
	private static final long serialVersionUID = -3363160517777222170L;

	public TimeException(final String message) {
		super(message);
	}

	public TimeException(final String message, final RuntimeException exception) {
		super(message, exception);
	}

}
