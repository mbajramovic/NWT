package com.example.scholarship.domain.exception;

public class ScholarshipNotFoundException extends RuntimeException {
	public ScholarshipNotFoundException(Integer id) {
		super("Could not find scholarship " + id);
	}
	public ScholarshipNotFoundException() {
		super("Could not find scholarship ");
	}
}
