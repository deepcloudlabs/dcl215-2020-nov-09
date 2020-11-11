package com.example.service.business;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.service.CustomerService;
import com.example.service.Quality;
import com.example.service.QualityLevel;

@Service
//@Quality(QualityLevel.FAST)
//@ConditionalOnProperty(name = "customer.service.mode", havingValue = "fast")

public class FastCustomerService implements CustomerService {

	@Override
	public void fun() {
		// TODO Auto-generated method stub

	}

	@Override
	public int gun() {
		return 108;
	}

}
