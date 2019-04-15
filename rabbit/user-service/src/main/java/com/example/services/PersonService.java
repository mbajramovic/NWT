package com.example.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Person;
import com.example.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	private Logger logger = LoggerFactory.getLogger(PersonService.class);
	private final RabbitTemplate rabbitTemplate;
	
	public PersonService(RabbitTemplate rabbitTemplate) {
		System.out.print("ajla personservice const");
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public Person save(Person person) {
		rabbitTemplate.convertAndSend("candidates.direct", "created", "created");
		return personRepository.save(person);
	}
	
	public Iterable<Person> saveAll(List<Person> persons) {
		return personRepository.saveAll(persons);
	}

	public void deleteAll() {
		personRepository.deleteAll();
		
	}

	
}
