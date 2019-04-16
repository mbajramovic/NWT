package com.example.scholarship.domain.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class UserListService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserRepository userRepository;
	
	@RabbitListener(queues = "#{candidateQueue.name}")
	public void getCandidateMessage(String candidateMessage) {
	  
		System.out.println("ovdje primam porikue");
	  
		ObjectMapper objectMapper = new ObjectMapper();
	  
	  //TypeReference<User> mapType = new TypeReference<User>() {};

	  User candidate = new User();

	  try {
		  objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	      candidate = objectMapper.readValue(candidateMessage, User.class);
	  } catch (IOException e) {
	      logger.info(String.valueOf(e));
	  }

	  userRepository.save(candidate);
	  logger.debug("Candidate {} saved to MongoDB", candidate.toString());
	}
	
	
	
	
}
