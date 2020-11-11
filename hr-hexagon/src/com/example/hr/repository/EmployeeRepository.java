package com.example.hr.repository;

import java.util.Optional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

public interface EmployeeRepository {

	boolean existsByIdentity(TcKimlikNo identity);

	Employee save(Employee employee);

	Optional<Employee> removeByIdentity(TcKimlikNo identity);

}
