package com.example.scholarship.sinc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.scholarship.domain.exception.EntityNotFoundException;

public interface ScholarshipController {
	
	@RequestMapping("scholarship")
	String scholarship() throws EntityNotFoundException;
	/*
	@RequestMapping("/scholarship/user")
	String scholarshipUser() throws EntityNotFoundException;
*/
}
