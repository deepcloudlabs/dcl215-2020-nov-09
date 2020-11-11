package com.example.hr.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.application.HrApplication;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;

@RestController
@RequestScope
@RequestMapping("/employees")
@CrossOrigin
// Adapter
public class HrController {
	@Autowired
	private HrApplication hrApp;
	@Autowired ModelMapper mapper;
	
	@PostMapping
	public HireEmployeeResponse hireEmployee(@RequestBody HireEmployeeRequest request) {
		var optEmp = hrApp.hireEmployee(request.toEmployee());
		if (optEmp.isPresent())
		   return new HireEmployeeResponse("ok",optEmp.get());
		return new HireEmployeeResponse("error", null);
	}
}
