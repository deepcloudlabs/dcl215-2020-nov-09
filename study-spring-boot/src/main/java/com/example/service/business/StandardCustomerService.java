package com.example.service.business;

import org.springframework.stereotype.Service;

import com.example.service.CustomerService;

//@Component  // P
@Service    // BL
//@Repository // I
//@RequestScope
//@SessionScope
//@Scope("singleton") // default
//@Quality(QualityLevel.STANDARD)
//@ConditionalOnProperty(name = "customer.service.mode", havingValue = "standard")
public class StandardCustomerService implements CustomerService {
	@Override
	public void fun() {
		System.err.println("have fun using StandardCustomerService");
	}
	@Override
	public int gun() { return 42;}
}
