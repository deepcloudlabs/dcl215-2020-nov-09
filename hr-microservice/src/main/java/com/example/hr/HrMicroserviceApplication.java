package com.example.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Actor -> Controller -> ACL -> Application -> MongoAdaptor -> ACL -> SpringData Mongo -> MongoDB
//                                           -> KafkaAdaptor -> ACL -> Spring Kafka -> Kafka 
@SpringBootApplication
public class HrMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrMicroserviceApplication.class, args);
	}

}
