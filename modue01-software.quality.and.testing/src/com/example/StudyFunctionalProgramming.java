package com.example;

import java.io.Serializable;
import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings("unused")
public class StudyFunctionalProgramming {
    // Interfaces: # of abstract method
	// 1. 0 -> Marker Interface : Serializable
	// 2. 1 -> Functional Interface -> SAM (Single Abstract Method)
	public static void main(String[] args) {
		// Type: primitive types, class
		int x = 42;
        N y = new N();
        // Type: function -> Functional Interface -> Built-in Functional Interfaces
        Function<Integer, Boolean> odd = null; // ? 
        // How to initialize functional variable
        // 1. Use Anonymous Class
        odd = new Function<Integer, Boolean>(){

			@Override
			public Boolean apply(Integer value) {
				return value % 2 == 1;
			}
        	
        };
        // 2. Lambda Expression (Java SE 8)
        odd = (Integer value) -> {
        		return value % 2 == 1;
        	};
    	odd = (value) -> {
    		return value % 2 == 1;
    	};
    	odd = value -> {
    		return value % 2 == 1;
    	};
    	odd = value -> value % 2 == 1;
    	// 3. Method Reference (Java SE 8)
        odd = n -> MyInteger.isOdd(n); 
    	odd = MyInteger::isOdd;
    	BiFunction<Integer, Integer, Long> multiply = (n1,n2) -> Long.valueOf(n1)*n2;
 
        // Function -> Method Reference -> Lambda Expression -> Anonymous Class
        System.err.println(odd.apply(42)); // calling from call site
        
        
	}

}

@FunctionalInterface
interface Fun5<U1,U2,U3,U4,U5,R> {
	R apply(U1 u1,U2 u2,U3 u3,U4 u4, U5 u5);
} 

interface MyInteger {
	static Boolean isOdd(Float n) {
		return n%2 == 1;
	}
	static Boolean isOdd(Integer n) {
		return n%2 == 1;
	}
	static Boolean isEven(Integer n) {
		return n%2 == 0;
	}
}

@SuppressWarnings("serial")
class N implements Serializable {} // java.io serialization

@FunctionalInterface
interface Fun { // SAM : fun -> Functional Interface
	int fun();
	default void gun() {}
	static void sun() {}
}