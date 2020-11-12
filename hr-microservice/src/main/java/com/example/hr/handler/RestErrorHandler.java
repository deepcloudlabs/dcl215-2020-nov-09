package com.example.hr.handler;

import static java.util.stream.Collectors.toMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.hr.exception.EmployeeNotFoundException;
import com.example.hr.exception.ExistingEmployeeException;

@RestControllerAdvice
public class RestErrorHandler {
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleValidationException(ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		return violations.stream()
				.collect(toMap(RestErrorHandler::getFieldName, ConstraintViolation::getMessage));
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		return ex.getBindingResult()
				.getAllErrors()
				.stream()
				.collect(toMap(ObjectError::getObjectName,ObjectError::getDefaultMessage));
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, Object> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", e.getMessage());
		response.put("identity", e.getIdentity());
		return response;
	}

	@ExceptionHandler(ExistingEmployeeException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleDuplicateEmployeeException(ExistingEmployeeException e) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", e.getMessage());
		response.put("identity", e.getIdentity());
		return response;
	}


	@ExceptionHandler(Throwable.class)
	@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
	public Map<String, Object> handleAllOtherExceptions(Throwable e) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", e.getMessage());
		response.put("debug", e.getClass().getSimpleName());
		return response;
	}	
	
	private static String getFieldName(ConstraintViolation<?> cv) {
		return cv.getPropertyPath().toString();
	} 
}
