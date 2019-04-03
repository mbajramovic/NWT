package com.example.scholarship.domain.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ScholarshipNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(ScholarshipNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(ScholarshipNotFoundException ex) {
		return ex.getMessage();
	}
}
