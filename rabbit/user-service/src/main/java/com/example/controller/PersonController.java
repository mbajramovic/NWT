package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PublishEventHandler;
import com.example.models.Person;
import com.example.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	@Autowired
	private PublishEventHandler publishEventHandler;
	
	@GetMapping("/personSave")
    public void savePerson() {
    	Person person = new Person();
    	//korisnik.setId(77);
    	personService.save(person);
    	publishEventHandler.handleCandidateSave(person);
    }
}
