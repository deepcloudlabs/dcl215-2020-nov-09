package com.example.hr.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {

	private final String identity;

	public EmployeeNotFoundException(String reason, String identity) {
		super(reason);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

}
