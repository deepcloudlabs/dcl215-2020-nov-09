package com.example.hr.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.EmployeeResponse;
import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;
import com.example.hr.exception.EmployeeNotFoundException;
import com.example.hr.exception.ExistingEmployeeException;

@RestController
@RequestScope
@RequestMapping("/employees")
@CrossOrigin
// Adapter
public class HrController {
	@Autowired
	private HrApplication hrApp;
	@Autowired
	private ModelMapper mapper;

	@PostMapping
	public HireEmployeeResponse hireEmployee(@RequestBody HireEmployeeRequest request) {
		return hrApp.hireEmployee(mapper.map(request, Employee.class))
				.map(emp -> new HireEmployeeResponse("ok", mapper.map(emp, EmployeeResponse.class)))
				.orElseThrow( () -> new ExistingEmployeeException("Cannot hire existing employee",request.getIdentity()));
	}

	@DeleteMapping("{identity}")
	public FireEmployeeResponse fireEmployee(@PathVariable String identity) {
		return hrApp.fireEmployee(TcKimlikNo.valueOf(identity))
		     .map( emp -> new FireEmployeeResponse("ok", mapper.map(emp,EmployeeResponse.class)))
		     .orElseThrow( () -> new EmployeeNotFoundException("Cannot fire non-exisiting employee",identity));
	}
}
