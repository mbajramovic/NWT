package com.example.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.example.models.Person;
import com.example.repositories.PersonRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CandidateListServices {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private PersonRepository _personRepository;

	@RabbitListener(queues = "#{candidateQueue.name}")
	public void getCandidateMessage(String candidateMessage) {
	  ObjectMapper objectMapper = new ObjectMapper();
	  objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	  TypeReference<Person> mapType = new TypeReference<Person>() {};

	  Person candidate = null;

	  try {
	      candidate = objectMapper.readValue(candidateMessage, mapType);
	  } catch (IOException e) {
	      logger.info(String.valueOf(e));
	  }

	  _personRepository.save(candidate);
	  logger.debug("Candidate {} saved to MongoDB", candidate.toString());
	}

	
}
