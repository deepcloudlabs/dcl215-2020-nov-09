package com.example.hr.domain;

// Ubiquitous Language -> Bounded Context
//Entity Class -> i. has identity ii. mutable class 
public class Employee {

	private final TcKimlikNo identity;

	public Employee(TcKimlikNo identity) {
		this.identity = identity;
	}

	public TcKimlikNo getIdentity() {
		return this.identity;
	}

}
