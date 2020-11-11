package com.example.service.business;

import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.stereotype.Service;

import com.example.service.CustomerService;
import com.example.service.Quality;
import com.example.service.QualityLevel;

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
	public void fun() {}
	@Override
	public int gun() { return 42;}
}
