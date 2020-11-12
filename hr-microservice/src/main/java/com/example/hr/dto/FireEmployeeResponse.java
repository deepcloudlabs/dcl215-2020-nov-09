package com.example.hr.dto;

import com.example.hr.domain.Employee;

public class FireEmployeeResponse {

	private String status;
	private EmployeeResponse employee;

	public FireEmployeeResponse(String status, Employee employeeEntity) {
		this.status = status;
		this.employee = new EmployeeResponse(employeeEntity);
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
