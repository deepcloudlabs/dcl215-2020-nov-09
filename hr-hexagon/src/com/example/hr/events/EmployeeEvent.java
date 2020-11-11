package com.example.hr.events;

public class EmployeeEvent {
	private String identity;

	public EmployeeEvent(String identity) {
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}
	
}
