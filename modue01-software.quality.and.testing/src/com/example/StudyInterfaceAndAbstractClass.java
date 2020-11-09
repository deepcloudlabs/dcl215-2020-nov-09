package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudyInterfaceAndAbstractClass {

	public static void main(String[] args) {
		// error: new A();
        new B();
        U u = new V();
        if(u instanceof X) {}
//not allowed:        if(u instanceof W) {}
	}

}

abstract class A {
	private int x;
	
	static void run() {}
	
	public A(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public abstract void fun() ; // has no body!
	
}

class B extends A { // concrete

	public B() {
		super(42);
	}

	@Override
	public void fun() {
		
	}
	
}

// until Java SE 8
abstract interface C {
	public static final int x = 42; // global constant
	// constructors are not allowed
	// concrete methods are not allowed
	// static methods are not allowed
	abstract void gun();
	public void sun(); // implicitly: public abstract
	default void run() { // since java se 8
		// implementation -> polymorphism
	};
	
}

interface LotteryService {
	List<Integer> draw();
	default List<List<Integer>> draw(int column){
		return IntStream.range(0,  column)
				.mapToObj( i -> this.draw())
				.collect(Collectors.toList());
	}
}

abstract class D implements C {
}

class E implements C {

	@Override
	public void gun() {
		
	}

	@Override
	public void sun() {
		
	}
	
}
// Differences between Abstract Class and Interface
// 1. extends -> Single Inheritance, implements -> Multiple
// 2. Interface -> Multiple Inheritance
interface X {}
interface Y {}
interface Z extends X, Y {} // Multiple Inheritance
// 3. instanceof
class U {}
class V extends U {}
class W {}


// Java SE 8 -> Functional Programming -> Stream API -> Collection API
// 1. Default Method -> API Evolution -> Backward Compatibility 
// 2. static method  -> Functional Programming -> Utility Functions

// Java SE 9 
// 1. private method  -> repetitive code block in default method -> private method
// 2. private static method -> repetitive code block in static method -> private static method