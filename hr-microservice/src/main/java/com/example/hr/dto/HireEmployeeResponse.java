package com.example.hr.dto;

import com.example.hr.domain.Employee;

public class HireEmployeeResponse {

	private String status;
	private EmployeeResponse employee;
	
	public HireEmployeeResponse(String status, Employee employeeEntity) {
		this.status = status;
		employee = new EmployeeResponse(employeeEntity);
	}

	public String getStatus() {
		return status;
	}

	public EmployeeResponse getEmployee() {
		return employee;
	}

}
