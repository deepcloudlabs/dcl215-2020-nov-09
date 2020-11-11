package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.StandardHrApplication;
import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Employee;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

@Configuration
public class AppConfig {
	private static final Converter<Employee, EmployeeDocument> employeeToEmployeDocumentConverter = context -> {
		var employeeDocument = new EmployeeDocument();
		var employee = context.getSource();
		System.err.println("converting employee to employee document");
		employeeDocument.setIdentity(employee.getIdentity().getValue());
		employeeDocument.setFirstname(employee.getFullname().getFirst());
		employeeDocument.setLastname(employee.getFullname().getLast());
		employeeDocument.setSalary(employee.getSalary().getValue());
		employeeDocument.setCurrency(employee.getSalary().getCurrency());
		employeeDocument.setIban(employee.getIban().getValue());
		return employeeDocument;
	};

	@Bean
	public HrApplication hrApplication(EmployeeRepository employeeRepository, EventPublisher publisher) {
		return new StandardHrApplication(employeeRepository, publisher);
	}

	@Bean
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(employeeToEmployeDocumentConverter,Employee.class,EmployeeDocument.class);
		return modelMapper;
	}
}
