package com.example.hr.domain;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("hr domain tests")
class EmployeeTest {

	@Test
	@DisplayName("create Employee aggregate")
	void createEmployee() {
		// 1. Fixture/Setup + 2. Exercise Method
		var identity = new TcKimlikNo("11111111110");
		var employee  = new Employee(identity); 
		// 3. Verification
		assertEquals("11111111110",employee.getIdentity().getValue());
		// 4. Tear-down
		// empty
	}

}
