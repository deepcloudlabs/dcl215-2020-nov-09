package com.example.service.business;

import org.springframework.stereotype.Service;

import com.example.service.CustomerService;

@Service
//@Quality(QualityLevel.FAST)
//@ConditionalOnProperty(name = "customer.service.mode", havingValue = "fast")
public class FastCustomerService implements CustomerService {

	@Override
	public void fun() {
		System.err.println("have fun using FastCustomerService");
	}

	@Override
	public int gun() {
		return 108;
	}

}
