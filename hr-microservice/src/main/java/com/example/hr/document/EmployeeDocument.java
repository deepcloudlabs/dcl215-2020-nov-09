package com.example.hr.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.hr.domain.Employee;
import com.example.hr.domain.FiatCurrency;
import com.example.hr.domain.Fullname;
import com.example.hr.domain.Iban;
import com.example.hr.domain.Money;
import com.example.hr.domain.TcKimlikNo;

@Document(collection = "emps")
public class EmployeeDocument {
	@Id
	private String identity;
	private String firstname;
	private String lastname;
	private String iban;
	private double salary;
	private FiatCurrency currency;

	public EmployeeDocument() {
	}

	public EmployeeDocument(String identity, String firstname, String lastname, String iban, double salary,
			FiatCurrency currency) {
		this.identity = identity;
		this.firstname = firstname;
		this.lastname = lastname;
		this.iban = iban;
		this.salary = salary;
		this.currency = currency;
	}

	public EmployeeDocument(Employee employee) {
		this.identity = employee.getIdentity().getValue();
		this.firstname = employee.getFullname().getFirst();
		this.lastname = employee.getFullname().getLast();
		this.salary = employee.getSalary().getValue();
		this.currency = employee.getSalary().getCurrency();
		this.iban = employee.getIban().getValue();
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

	public Employee toEmployee() {
		return new Employee(TcKimlikNo.valueOf(identity), Fullname.of(firstname, lastname), Iban.valueOf(iban),
				Money.of(salary, currency));
	}

	@Override
	public String toString() {
		return "EmployeeDocument [identity=" + identity + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", iban=" + iban + ", salary=" + salary + ", currency=" + currency + "]";
	}

}
