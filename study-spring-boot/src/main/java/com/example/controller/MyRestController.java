package com.example.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.service.CustomerService;

// RESTful Service
// 1. URI
// 2. HTTP METHOD
// 3. MIME -> Resource: application/json, application/xml, ...
// Spring Boot: opionated framework -> 3: application/json 
@RestController
@RequestScope
@RequestMapping("numbers") // -> 1. URI
// http://localhost:8100/app/api/v1/numbers
public class MyRestController {
	@Autowired // 1. Field injection
	private List<CustomerService> customerServices;
	private static AtomicInteger counter = new AtomicInteger(0);
	// @Autowired // 2. property/setter injection
	/*
	public void setCustomerSrv(CustomerService customerSrv) {
		this.customerSrv = customerSrv;
	}*/

	// @Autowired // 3. Constructor Injection
	/*public MyRestController(@Quality(QualityLevel.STANDARD) CustomerService customerSrv) {
		this.customerSrv = customerSrv;
	}
	*/

	@GetMapping
	public int getNumber() {
		var index = counter.getAndIncrement() % customerServices.size();
		CustomerService customerSrv = customerServices.get(index);
		return customerSrv .gun();
	}
}
