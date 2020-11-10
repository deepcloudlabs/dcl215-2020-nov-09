package com.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@FunctionalTest
public class UseTags {
	@Test
	void test1() {
		
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
		
	}
	@Test
	@StressTest
	void test3() {
		
	}
}
