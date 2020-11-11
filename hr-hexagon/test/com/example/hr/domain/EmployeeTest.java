package com.example.hr.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("hr sub-domain tests")
class EmployeeTest {

	@Test
	@DisplayName("successfully creates an Employee aggregate")
	void createEmployee() {
		// 1. Fixture/Setup + 2. Exercise Method
		var identity = TcKimlikNo.valueOf("11111111110");
		var fullname = Fullname.of("jack", "bauer");
		var iban = Iban.valueOf("tr1");
		var salary = Money.of(10_000, FiatCurrency.TRY);
		var employee = new Employee(identity, fullname,iban,salary);
		// 3. Verification
		assertEquals("11111111110", employee.getIdentity().getValue());
		assertEquals("jack", employee.getFullname().getFirst());
		assertEquals("bauer", employee.getFullname().getLast());
		assertEquals("tr1", employee.getIban().getValue());
		assertEquals(10_000, employee.getSalary().getValue());
		assertEquals(FiatCurrency.TRY, employee.getSalary().getCurrency());
		// 4. Tear-down
		// empty
	}

}
