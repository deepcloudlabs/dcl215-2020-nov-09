package com.example.hr.dto;

import com.example.hr.domain.Employee;
import com.example.hr.domain.FiatCurrency;

public class EmployeeResponse {
	private String identity;
	private String firstname;
	private String lastname;
	private String iban;
	private double salary;
	private FiatCurrency currency;

	public EmployeeResponse() {
	}

	public EmployeeResponse(Employee employeeEntity) {
		this.identity = employeeEntity.getIdentity().getValue();
		this.firstname = employeeEntity.getFullname().getFirst();
		this.lastname = employeeEntity.getFullname().getLast();
		this.salary = employeeEntity.getSalary().getValue();
		this.currency = employeeEntity.getSalary().getCurrency();
		this.iban = employeeEntity.getIban().getValue();
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public FiatCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(FiatCurrency currency) {
		this.currency = currency;
	}

}
