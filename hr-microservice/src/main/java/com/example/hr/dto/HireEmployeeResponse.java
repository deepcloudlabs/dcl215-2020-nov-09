package com.example.hr.dto;

public class HireEmployeeResponse {

	private String status;
	private EmployeeResponse employee;

	public HireEmployeeResponse(String status, EmployeeResponse employeeResponse) {
		this.status = status;
		employee = employeeResponse;
	}

	public String getStatus() {
		return status;
	}

	public EmployeeResponse getEmployee() {
		return employee;
	}

}
