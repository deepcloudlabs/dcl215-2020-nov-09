package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Yük Testi")
public class StudyTestLifeCycle extends AbstractBaseTest {

	@BeforeEach
	void beforeEachTest() {
		
		System.err.println("@BeforeEach runs once before each test method.");
	}

	@AfterEach
	void afterEachTest() {
		System.err.println("@AfterEach runs once before each test method.");
	}

	@Test
	@DisplayName("test1 testi")
	@Order(3)
	void test1() {
		System.err.println("test1().");
	}

	@Test
	@DisplayName("test2 testi")
	@Order(2)
	void test2() {
		System.err.println("test2().");
	}

	@Test
	@DisplayName("test3 testi")
	@Order(1)
	void test3() {
		System.err.println("test3().");
	}
}
