package com.example.hr.exception;

@SuppressWarnings("serial")
public class ExistingEmployeeException extends RuntimeException {

	private final String identity;

	public ExistingEmployeeException(String reason, String identity) {
		super(reason);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

}
