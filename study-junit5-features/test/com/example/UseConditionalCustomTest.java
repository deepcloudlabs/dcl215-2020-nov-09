package com.example;

import org.junit.jupiter.api.Test;

import com.example.conditional.ConditionalTestOnOperatingSystem;
import com.example.conditional.OperatingSystemEnum;

public class UseConditionalCustomTest {

	@Test
	@ConditionalTestOnOperatingSystem(value = { OperatingSystemEnum.UNIX })
	void test1() {
		System.err.println("test1() is running");
	}
	
	@Test
	@ConditionalTestOnOperatingSystem(value = { OperatingSystemEnum.WINDOWS })
	void test2() {
		System.err.println("test2() is running");
	}
	
	@Test
	@ConditionalTestOnOperatingSystem(value = { OperatingSystemEnum.WINDOWS, OperatingSystemEnum.UNIX })
	void test3() {
		System.err.println("test3() is running");
	}
}
