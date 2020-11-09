package com.example.random.service;

// ISP: Interface Segregation Principle
public interface RandomNumberService {
	int generate(int min,int max);
	boolean flip();
}
