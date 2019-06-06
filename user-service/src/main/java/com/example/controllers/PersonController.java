package com.example.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.server.ResponseStatusException;

import com.example.RabbitMqEventHandler;
import com.example.exception.EntityNotFoundException;
import com.example.models.Person;
import com.example.request.AuthenticationRequest;
import com.example.response.JWTTokenResponse;
import com.example.services.PersonService;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


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
        	System.out.println("U controlleru");
        	Person savedPerson = personService.save(person);
        	System.out.println("Spasila");
        	rabbitMqEventHandler.handleCandidateSave(savedPerson);
        	System.out.println("Poslala poruku");
        	return ResponseEntity.status(HttpStatus.OK).body(savedPerson);
        }
        catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
    @RequestMapping(method = RequestMethod.POST, value = "/newww")
    public ResponseEntity<Person> newwwUser(@RequestBody Person person) {
        try {
        	System.out.println(person.toString());
        	Person savedPerson = personService.save(person);
        	//rabbitMqEventHandler.handleCandidateSave(savedPerson);
        	return new ResponseEntity<Person>(person, HttpStatus.CREATED);
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
	public ResponseEntity replaceUser(@RequestBody Person newUser, @PathVariable Integer id) {
		try {
			
			Person savedPerson = personService.update(newUser, id);
        	rabbitMqEventHandler.handleAfterSaved(savedPerson);
        	return ResponseEntity.status(HttpStatus.OK).body(savedPerson);
        }
        catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
    
    @GetMapping("/")
	public Iterable<Person> allPersons() {
    	
		try {
			return personService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		}
    
    @PostMapping("/login")
    public ResponseEntity createCustomer(@RequestBody AuthenticationRequest request) {
        System.out.println("evo u contoleru");
    	return new ResponseEntity<>(personService.generateJWTToken(request.getUsername(), request.getPassword()), HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    
}