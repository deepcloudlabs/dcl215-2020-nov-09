package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

public class UseParallelTest {
    private int counter= 0;
	@Test
	void test1() {
		System.err.println("test1()");
	}

	@Test
	@ResourceLock(value= "shared", mode=ResourceAccessMode.READ_WRITE)
	void test2() {
		counter++;
		System.err.println("test2()");
	}

	@Test
	@ResourceLock(value= "shared", mode=ResourceAccessMode.READ)
	void test3() {
		System.err.println("test3(): "+counter);
	}

	@Test
	@ResourceLock(value= "shared", mode=ResourceAccessMode.READ_WRITE)
	void test4() {
		counter++;
		System.err.println("test4()");
	}

	@Test
	void test5() {
		System.err.println("test5()");
	}

	@Test
	void test6() {
		System.err.println("test6()");
	}
}
