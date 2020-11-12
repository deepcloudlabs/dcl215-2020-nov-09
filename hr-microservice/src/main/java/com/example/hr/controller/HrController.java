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
import com.example.hr.dto.FireEmployeeResponse;
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
	@Autowired
	private ModelMapper mapper;

	@PostMapping
	public HireEmployeeResponse hireEmployee(@RequestBody HireEmployeeRequest request) {
		Employee employee = request.toEmployee();
		var optEmp = hrApp.hireEmployee(employee);
		if (optEmp.isPresent()) {
			return new HireEmployeeResponse("ok", optEmp.get());
		}
		return new HireEmployeeResponse("error", null);
	}

	@DeleteMapping("{identity}")
	public FireEmployeeResponse fireEmployee(@PathVariable String identity) {
		var optEmp = hrApp.fireEmployee(TcKimlikNo.valueOf(identity));
		if (optEmp.isPresent()) {
			return new FireEmployeeResponse("ok", optEmp.get());
		}
		return new FireEmployeeResponse("error", null);
	}
}
