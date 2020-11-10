package com.example.hr.domain;

public class StringCaching {

	public static void main(String[] args) {
		String name1 = "jack";
		String name2 = "jack";
		String name3 = new String("jack");
		name3 = name3.intern();
		System.err.println("name1==name2: "+(name1==name2));
		System.err.println("name1==name3: "+(name1==name3));
		Integer i = Integer.valueOf(42);
		Integer j = 42;
		Integer x = 3615;
		Integer y = 3615;
		System.err.println("i==j: "+(i==j));
		System.err.println("x==y: "+(x==y));
		
	}

}
