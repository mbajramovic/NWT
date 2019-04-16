package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.RabbitMqEventHandler;
import com.example.models.Person;

import com.example.services.PersonService;

@RestController
@RequestMapping("/user")
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
	private RabbitMqEventHandler rabbitMqEventHandler;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getUser(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.getPerson(id));
        }
        catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id) {
        try {
            personService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public ResponseEntity newUser(@RequestBody Person person) {
        try {
        	Person savedPerson = personService.save(person);
        	rabbitMqEventHandler.handleCandidateSave(savedPerson);
            return ResponseEntity.status(HttpStatus.OK).body(savedPerson);
        }
        catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/find")
    public ResponseEntity findUser(@RequestBody Person person) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.findPerson(person.getUsername(), person.getPassword()));
        }
        catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
    @PutMapping("/{id}")
	public void replaceUser(@RequestBody Person newUser, @PathVariable Integer id) {
		try {
			
			Person savedPerson = personService.update(newUser, id);
        	//rabbitMqEventHandler.handleAfterSaved(savedPerson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
    
}