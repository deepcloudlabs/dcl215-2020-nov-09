package com.example.hr.application;

import java.util.Optional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

public interface HrApplication {

	default Optional<Employee> hireEmployee(Employee employee){ return Optional.empty();}

	default Optional<Employee> fireEmployee(TcKimlikNo identity){return Optional.empty();}

}
