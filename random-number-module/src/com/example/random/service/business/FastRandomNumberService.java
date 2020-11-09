package com.example.random.service.business;

import java.util.concurrent.ThreadLocalRandom;

import com.example.random.service.RandomNumberService;

public class FastRandomNumberService implements RandomNumberService {

	public FastRandomNumberService() {
		System.err.println("FastRandomNumberService()");
	}

	@Override
	public int generate(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

	@Override
	public boolean flip() {
		return ThreadLocalRandom.current().nextBoolean();
	}

}
