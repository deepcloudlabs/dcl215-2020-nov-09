package com.example.hr.dto;

import com.example.hr.domain.Employee;
import com.example.hr.domain.FiatCurrency;
import com.example.hr.domain.Fullname;
import com.example.hr.domain.Iban;
import com.example.hr.domain.Money;
import com.example.hr.domain.TcKimlikNo;

public class HireEmployeeRequest {

	private String identity;
	private String firstname;
	private String lastname;
	private String iban;
	private double salary;
	private FiatCurrency currency;

	public HireEmployeeRequest() {
	}

	public HireEmployeeRequest(String identity, String firstname, String lastname, String iban, double salary,
			FiatCurrency currency) {
		this.identity = identity;
		this.iban = iban;
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
		this.currency = currency;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setCurrency(FiatCurrency currency) {
		this.currency = currency;
	}

	public String getIdentity() {
		return identity;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public double getSalary() {
		return salary;
	}

	public FiatCurrency getCurrency() {
		return currency;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Override
	public String toString() {
		return "HireEmployeeRequest [identity=" + identity + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", salary=" + salary + ", currency=" + currency + "]";
	}

	// ACL: Anti-corruption Layer
	public Employee toEmployee() {
		return new Employee(TcKimlikNo.valueOf(identity), Fullname.of(firstname, lastname), 
				Iban.valueOf(iban),Money.of(salary, currency));
	}

}
