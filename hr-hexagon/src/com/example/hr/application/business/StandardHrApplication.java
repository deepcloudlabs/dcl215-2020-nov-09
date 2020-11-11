package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.events.EmployeeFiredEvent;
import com.example.hr.events.EmployeeHiredEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

public class StandardHrApplication implements HrApplication {
    private EmployeeRepository employeeRepository;
    private EventPublisher publisher;
    
	public StandardHrApplication(EmployeeRepository employeeRepository,EventPublisher publisher) {
		this.employeeRepository = employeeRepository;
		this.publisher = publisher;
	}

	@Override
	public Optional<Employee> hireEmployee(Employee employee) {
		var identity = employee.getIdentity();
		if (employeeRepository.existsByIdentity(identity ))
			return Optional.empty();
		Employee emp = employeeRepository.save(employee);
		publisher.publishEvent(new EmployeeHiredEvent(identity.getValue()));
		return Optional.of(emp);
	}


	@Override
	public Optional<Employee> fireEmployee(TcKimlikNo identity) {
		if (employeeRepository.existsByIdentity(identity )) {
			var emp = employeeRepository.removeByIdentity(identity);
			publisher.publishEvent(new EmployeeFiredEvent(identity.getValue()));
			return emp;
		}
   		return Optional.empty();
	}

}
