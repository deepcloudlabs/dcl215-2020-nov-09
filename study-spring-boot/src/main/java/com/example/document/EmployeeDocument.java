package com.example.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class EmployeeDocument {
	@Id
	private String identity;
	private String fullname;
	private String iban;
	private double salary;

	public EmployeeDocument() {
	}

	public EmployeeDocument(String identity, String fullname, String iban, double salary) {
		this.identity = identity;
		this.fullname = fullname;
		this.iban = iban;
		this.salary = salary;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	@Override
	public String toString() {
		return "EmployeeDocument [identity=" + identity + ", fullname=" + fullname + ", iban=" + iban + ", salary="
				+ salary + "]";
	}

}
