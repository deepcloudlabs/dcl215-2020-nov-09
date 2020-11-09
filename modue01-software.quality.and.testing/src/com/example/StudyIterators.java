package com.example;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudyIterators {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(4,8,23,42,16,15);
		// Iterator: External Loop #1 
		var sum = 0;
		for (var iter = numbers.iterator();iter.hasNext();) {
			var number = iter.next();
			sum += number;
		}
		System.err.println("Sum: "+sum);
		// Iterator: External Loop #2 (Java SE 5)
		for (var number : numbers)
			sum += number;
		// Stream API (Java SE 8) + Filter/Map/Reduce -> Internal Loop
		Predicate<Integer> ifEven = x -> x%2 == 0;
		Function<Integer,Integer> squared = y -> y * y;
		// Side Effect 
		int[] state= {100};
		int w= 100; //effective final
		
		BinaryOperator<Integer> accumulate = (s,z)-> { state[0]++;  return s+z+w;};
		sum = numbers.stream()
				     .parallel()
				     .peek(System.out::println)
			         .filter(ifEven)
			         .peek(System.out::println)
			         .map(squared)
			         .peek(System.out::println)
			         .reduce(0, accumulate);
		// Generator Function -> C++20/JS (yield)
		// Spliterator vs Iterator
		       
	}

}
