package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.document.EmployeeDocument;

public interface EmployeeDocumentRepository extends MongoRepository<EmployeeDocument, String>{

}
