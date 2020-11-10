package com.example.hr.domain;

// Ubiquitous Language -> Bounded Context
//Entity Class -> i. has identity ii. mutable class 
// 12-Byte : Object Header
// JVM: JIT Compiler -> Method Inlining
public class Employee {

	private final TcKimlikNo identity;
	private Fullname fullname;

	public Employee(TcKimlikNo identity,Fullname fullname) {
		this.identity = identity;
		this.fullname = fullname;
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
	

}
