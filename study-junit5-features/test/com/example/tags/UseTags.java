package com.example.tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.LoadTest;
import com.example.StressTest;

//@FunctionalTest
@Tag("stress")
public class UseTags {
	@Test
	void test1() {
		System.err.println("test1");	
	}
	@Test
	@LoadTest
	/*
	@Tags({
		@Tag("stress"),
		@Tag("load")		
	})
	*/
	@Tag("stress")
	@Tag("load")	
	void test2() {
		System.err.println("test2");			
	}
	@Test
	@StressTest
	void test3() {
		System.err.println("test3");					
	}
}
