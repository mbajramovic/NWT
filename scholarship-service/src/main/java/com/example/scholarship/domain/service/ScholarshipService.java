package com.example.scholarship.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholarship.domain.entity.Scholarship;
import com.example.scholarship.domain.repository.ScholarshipRepository;

@Service
public class ScholarshipService {

	@Autowired
	ScholarshipRepository scholarshipRepository;
	
	public void newScholarship(Scholarship scholarship) {
		scholarshipRepository.save(scholarship);
	}
	
	public void deleteAll() {
		scholarshipRepository.deleteAll();
	}
	
	public Iterable<Scholarship> getAll() {
		return scholarshipRepository.findAll();
	}
}
