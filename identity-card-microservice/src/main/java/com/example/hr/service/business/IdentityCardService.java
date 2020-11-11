package com.example.hr.service.business;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class IdentityCardService {

	@KafkaListener(topics = "employees")
	public void readMessage(String message) {
		System.err.println("Received message: "+message);
	}
}
