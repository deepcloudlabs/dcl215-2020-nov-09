package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.StandardHrApplication;
import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Employee;
import com.example.hr.domain.Fullname;
import com.example.hr.domain.Iban;
import com.example.hr.domain.Money;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.EmployeeKafkaEvent;
import com.example.hr.dto.EmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.events.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

@Configuration
public class AppConfig {
	private static final Converter<Employee, EmployeeDocument> employeeToEmployeDocumentConverter = context -> {
		var employeeDocument = new EmployeeDocument();
		var employee = context.getSource();
		employeeDocument.setIdentity(employee.getIdentity().getValue());
		employeeDocument.setFirstname(employee.getFullname().getFirst());
		employeeDocument.setLastname(employee.getFullname().getLast());
		employeeDocument.setSalary(employee.getSalary().getValue());
		employeeDocument.setCurrency(employee.getSalary().getCurrency());
		employeeDocument.setIban(employee.getIban().getValue());
		return employeeDocument;
	};
	private static final Converter<Employee, EmployeeResponse> employeeToEmployeResonponseConverter = context -> {
		var employeeResponse = new EmployeeResponse();
		var employee = context.getSource();
		employeeResponse.setIdentity(employee.getIdentity().getValue());
		employeeResponse.setFirstname(employee.getFullname().getFirst());
		employeeResponse.setLastname(employee.getFullname().getLast());
		employeeResponse.setSalary(employee.getSalary().getValue());
		employeeResponse.setCurrency(employee.getSalary().getCurrency());
		employeeResponse.setIban(employee.getIban().getValue());
		return employeeResponse;
	};
	private static final Converter<HireEmployeeRequest, Employee> hireEmployeeRequestToEmployeConverter = context -> {
		var employee = context.getSource();
		return new Employee(
				TcKimlikNo.valueOf(employee.getIdentity()), 
				Fullname.of(employee.getFirstname(), employee.getLastname()), 
				Iban.valueOf(employee.getIban()),
				Money.of(employee.getSalary(), employee.getCurrency())
		);	
	};
	private static final Converter<EmployeeEvent, EmployeeKafkaEvent> employeeEventToEmployeeKafkaEventConverter = context -> {
		var event = context.getSource();
		return new EmployeeKafkaEvent(event.getIdentity());	
	};

	@Bean
	public HrApplication hrApplication(EmployeeRepository employeeRepository, EventPublisher publisher) {
		return new StandardHrApplication(employeeRepository, publisher);
	}

	@Bean
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(employeeToEmployeDocumentConverter, Employee.class, EmployeeDocument.class);
		modelMapper.addConverter(employeeToEmployeResonponseConverter, Employee.class, EmployeeResponse.class);
		modelMapper.addConverter(hireEmployeeRequestToEmployeConverter, HireEmployeeRequest.class, Employee.class);
		modelMapper.addConverter(employeeEventToEmployeeKafkaEventConverter, EmployeeEvent.class, EmployeeKafkaEvent.class);
		return modelMapper;
	}
}
