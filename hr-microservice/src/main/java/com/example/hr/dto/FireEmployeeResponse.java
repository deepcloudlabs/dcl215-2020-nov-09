package com.example.hr.dto;

public class FireEmployeeResponse {

	private String status;
	private EmployeeResponse employee;

	public FireEmployeeResponse(String status, EmployeeResponse employeeResponse) {
		this.status = status;
		this.employee = employeeResponse;
	}

	public String getStatus() {
		return status;
	}

	public EmployeeResponse getEmployee() {
		return employee;
	}

	@Override
	public String toString() {
		return "FireEmployeeResponse [status=" + status + ", employee=" + employee + "]";
	}

}
