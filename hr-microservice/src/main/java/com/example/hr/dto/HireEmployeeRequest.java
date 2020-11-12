package com.example.hr.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.hr.domain.FiatCurrency;
import com.example.validation.IbanNo;
import com.example.validation.KimlikNo;

public class HireEmployeeRequest {
	@KimlikNo
	private String identity;
	@NotEmpty
	private String firstname;
	@NotEmpty
	private String lastname;
	@IbanNo
	private String iban;
	@Min(3000)
	private double salary;
	@NotNull
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

}
