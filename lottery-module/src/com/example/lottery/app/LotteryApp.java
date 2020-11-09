package com.example.lottery.app;

import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.RandomNumberService;

public class LotteryApp {

	public static void main(String[] args) {
		ServiceLoader<RandomNumberService> randomNumberServices = 
				    ServiceLoader.load(RandomNumberService.class);
		//for (var randomNumberService: randomNumberServices)
		//	System.err.println(randomNumberService.getClass().getName());
		var lotteryService = new StandardLotteryService();
		lotteryService.setRandomNumberService(randomNumberServices.findFirst().get());
		var numbers = lotteryService.draw() ;
		System.err.println(numbers);
		// Proxy.newProxyInstance(loader, interfaces, h)
	}

}
