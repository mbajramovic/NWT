package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PublishEventHandler;
import com.example.models.Person;
import com.example.services.PersonService;

/** Klasa predstavlja RestController. Implementira potrebne rute za manipulaciju podacima o korisniku.
 * @author Becic Ajla
*/

@RestController
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	PersonService personService;
	@Autowired
	private PublishEventHandler publishEventHandler;
	
	//@RequestMapping(value="/new", method=RequestMethod.POST)
	@PostMapping("/new")
    public void savePerson(@Valid @RequestBody Person person) {
    	//Person person = new Person();
    	System.out.println("ajla person controller");
    	//korisnik.setId(77);
    	personService.save(person);
    	publishEventHandler.handleCandidateSave(person);
    }
}
