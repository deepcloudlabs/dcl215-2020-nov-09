package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.document.EmployeeDocument;
import com.example.repository.EmployeeDocumentRepository;

@SpringBootApplication
public class StudySpringBootApplication implements ApplicationRunner{
	@Autowired
	private EmployeeDocumentRepository employeeDocumentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StudySpringBootApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		EmployeeDocument employeeDocument = new EmployeeDocument("11111111110", "jack bauer", "tr1", 10_000);
		employeeDocumentRepository.save(employeeDocument);		
	}

}
