package com.example.sinc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("spring-cloud-eureka-client-scholarship")
public interface ScholarshipComm {
	
	@RequestMapping("/scholarship")
	String scholarship();
	
	/*
	@GetMapping("/scholarship/user")
	String scholarshipUser();//id
	*/
}
