package com.example.hr.domain;

// Ubiquitous Language -> Bounded Context
//Entity Class -> i. has identity ii. mutable class
// Aggregate -> Entity Root
// 12-Byte : Object Header
// JVM: JIT Compiler -> Method Inlining
public class Employee {

	private final TcKimlikNo identity;
	private Fullname fullname;
	private Iban iban;
	private Money salary;

	
	public Employee(TcKimlikNo identity,Fullname fullname,Iban iban,Money salary) {
		this.identity = identity;
		this.fullname = fullname;
		this.iban = iban;
		this.salary = salary;
	}

	public TcKimlikNo getIdentity() {
		return this.identity;
	}

	public Fullname getFullname() {
		return this.fullname;
	}

	public void setFullname(Fullname fullname) {
		this.fullname = fullname;
	}

	public Iban getIban() {
		return this.iban;
	}

	public Money getSalary() {
		return this.salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", fullname=" + fullname + ", iban=" + iban + ", salary=" + salary
				+ "]";
	}
	

}
