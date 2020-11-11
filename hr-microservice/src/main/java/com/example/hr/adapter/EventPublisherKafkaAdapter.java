package com.example.hr.adapter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.dto.EmployeeKafkaEvent;
import com.example.hr.events.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;

// GoF Adapter -> Object Adapter
@Service
public class EventPublisherKafkaAdapter implements EventPublisher{
	@Autowired
	// GoF: Template Pattern
	private KafkaTemplate<String, EmployeeKafkaEvent> kafkaTemplate;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public boolean publishEvent(EmployeeEvent event) {
		kafkaTemplate.send("employees", new EmployeeKafkaEvent(event.getIdentity()));
		return true;
	}

}
