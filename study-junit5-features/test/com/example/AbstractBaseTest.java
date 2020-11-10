package com.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractBaseTest {
	@BeforeAll
	static void beforeAllTests() {
		System.err.println("@BeforeAll runs once before all test methods.");
	}

	@AfterAll
	static void afterAllTests() {
		System.err.println("@AfterAll runs once after all test methods.");
	}
}
