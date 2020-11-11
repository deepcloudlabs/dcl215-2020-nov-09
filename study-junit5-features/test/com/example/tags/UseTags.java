package com.example.tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.StressTest;

public class UseTags {
	@Test
	@Tag("functional")
	void test1() {
		System.err.println("test1");
	}

	@Test
	@Tag("stress")
	void test2() {
		System.err.println("test2");
	}

	@Test
	@Tag("stress")
	void test3() {
		System.err.println("test3");
	}
}
