package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.repository.EmployeeDocumentRepository;
import com.example.hr.repository.EmployeeRepository;

// GoF: Object Adapter
@Repository
public class EmployeeRepositoryMongoAdapter implements EmployeeRepository {
	@Autowired
	private EmployeeDocumentRepository empDocRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public boolean existsByIdentity(TcKimlikNo identity) {
		return empDocRepository.existsById(identity.getValue());
	}

	@Override
	public Employee save(Employee employee) {
		// ACL: Anti-Corruption Layer
		var employeDocument = mapper.map(employee, EmployeeDocument.class);
		var empDoc = empDocRepository.save(employeDocument);
		return empDoc.toEmployee();
	}

	@Override
	public Optional<Employee> removeByIdentity(TcKimlikNo identity) {
		var empDoc = empDocRepository.findById(identity.getValue());
		if (empDoc.isPresent()) {
			EmployeeDocument entity = empDoc.get();
			empDocRepository.delete(entity);
			return Optional.of(entity.toEmployee());
		}
		return Optional.empty();
	}

}
