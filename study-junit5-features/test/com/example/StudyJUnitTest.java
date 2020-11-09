package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class StudyJUnitTest {

	@Test
	void test() {
		var numbers = List.of(4,8,15,16,23,42);
		assertEquals(4, numbers.stream().filter(n -> n%2 == 0).count());
	}

}
