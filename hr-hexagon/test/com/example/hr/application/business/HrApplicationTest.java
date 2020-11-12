package com.example.hr.application.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.Fullname;
import com.example.hr.domain.Iban;
import com.example.hr.domain.Money;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.events.EmployeeFiredEvent;
import com.example.hr.events.EmployeeHiredEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

@DisplayName("hr application")
class HrApplicationTest {

	@Test
	@DisplayName("hires an employee successfuly")
	void hireEmployeeSuccessfuly() {
		// 1 Fixture/Setup
		var employeeRepository = Mockito.mock(EmployeeRepository.class);
		var eventPublisher = Mockito.mock(EventPublisher.class);
		HrApplication hrApp = new StandardHrApplication(employeeRepository,eventPublisher);
		TcKimlikNo identity = TcKimlikNo.valueOf("11111111110");
		Fullname fullname= Fullname.of("jack", "bauer");
		Iban iban = Iban.valueOf("tr1");
		Money salary = Money.of(10_000.);
		Employee employee = new Employee(identity, fullname, iban, salary);
		Employee retemp = new Employee(identity, fullname, iban, salary);
		Mockito.when(employeeRepository.existsByIdentity(identity)).thenReturn(false);
		Mockito.when(employeeRepository.save(employee)).thenReturn(retemp);
		Mockito.when(eventPublisher.publishEvent(new EmployeeHiredEvent(identity.getValue())))
		     .thenReturn(true);
		// 2. Call Exercise Method
		var optemp = hrApp.hireEmployee(employee);
		// 3. Verification
		assertTrue(optemp.isPresent());
		var emp = optemp.get();
		assertEquals("11111111110", emp.getIdentity().getValue());
		assertEquals("jack", emp.getFullname().getFirst());
		assertEquals("bauer", emp.getFullname().getLast());
		// 4. Tear-down
		// empty
	}

	@Test
	@DisplayName("hires an existing employee returns empty")
	void hireEmployeeAlreadyExists() {
		// 1. Fixture/Setup
		var employeeRepository = Mockito.mock(EmployeeRepository.class);
		var eventPublisher = Mockito.mock(EventPublisher.class);
		HrApplication hrApp = new StandardHrApplication(employeeRepository,eventPublisher);
		TcKimlikNo identity = TcKimlikNo.valueOf("11111111110");
		Fullname fullname= Fullname.of("jack", "bauer");
		Iban iban = Iban.valueOf("tr1");
		Money salary = Money.of(10_000.);
		Employee employee = new Employee(identity, fullname, iban, salary);
		Mockito.when(employeeRepository.existsByIdentity(identity)).thenReturn(true);
		// 2. Call Exercise Method
		var optemp = hrApp.hireEmployee(employee);
		// 3. Verification
		assertTrue(optemp.isEmpty());
		// 4. Tear-down
		// empty
	}
	
	@Test
	@DisplayName("fires an employee successfuly")
	void fireEmployeeSuccessfuly() {
		// 1 Fixture/Setup
		var employeeRepository = Mockito.mock(EmployeeRepository.class);
		var eventPublisher = Mockito.mock(EventPublisher.class);
		HrApplication hrApp = new StandardHrApplication(employeeRepository,eventPublisher);
		TcKimlikNo identity = TcKimlikNo.valueOf("11111111110");
		Fullname fullname= Fullname.of("jack", "bauer");
		Iban iban = Iban.valueOf("tr1");
		Money salary = Money.of(10_000.);
		Employee employee = new Employee(identity, fullname, iban, salary);
		Mockito.when(employeeRepository.existsByIdentity(identity)).thenReturn(true);
		Mockito.when(employeeRepository.removeByIdentity(identity)).thenReturn(Optional.of(employee));
		Mockito.when(eventPublisher.publishEvent(new EmployeeFiredEvent(identity.getValue())))
	     .thenReturn(true);
		// 2. Call Exercise Method
		var optemp = hrApp.fireEmployee(identity);
		// 3. Verification
		assertTrue(optemp.isPresent());
		var emp = optemp.get();
		assertEquals("11111111110", emp.getIdentity().getValue());
		assertEquals("jack", emp.getFullname().getFirst());
		assertEquals("bauer", emp.getFullname().getLast());
		// 4. Tear-down
		// empty
	}
	
	@Test
	@DisplayName("fires non exisiting employee")
	void fireNonExisitngEmployee() {
		// 1 Fixture/Setup
		var employeeRepository = Mockito.mock(EmployeeRepository.class);
		var eventPublisher = Mockito.mock(EventPublisher.class);		
		HrApplication hrApp = new StandardHrApplication(employeeRepository,eventPublisher);
		TcKimlikNo identity = TcKimlikNo.valueOf("11111111110");

		Mockito.when(employeeRepository.existsByIdentity(identity)).thenReturn(false);
		// 2. Call Exercise Method
		var optemp = hrApp.fireEmployee(identity);
		// 3. Verification
		assertTrue(optemp.isEmpty());
		// 4. Tear-down
		// empty
	}

}
