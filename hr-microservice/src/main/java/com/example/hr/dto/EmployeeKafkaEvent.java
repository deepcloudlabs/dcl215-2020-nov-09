package com.example.hr.dto;

import java.util.UUID;

public class EmployeeKafkaEvent {
	private String eventId;
	private String identity;
	
	public EmployeeKafkaEvent() {
	}

	public EmployeeKafkaEvent(String identity) {
		this.identity = identity;
		this.eventId = UUID.randomUUID().toString();
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
}
