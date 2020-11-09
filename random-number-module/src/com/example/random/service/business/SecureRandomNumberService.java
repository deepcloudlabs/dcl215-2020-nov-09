package com.example.random.service.business;

import java.security.SecureRandom;

import com.example.random.service.RandomNumberService;

public class SecureRandomNumberService implements RandomNumberService {
	private SecureRandom random = new SecureRandom();

	public SecureRandomNumberService() {
		System.err.println("SecureRandomNumberService()");
	}

	@Override
	public int generate(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

	@Override
	public boolean flip() {
		return random.nextBoolean();
	}

}
