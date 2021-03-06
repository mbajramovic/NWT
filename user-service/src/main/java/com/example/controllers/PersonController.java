package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public ResponseEntity getUser(@PathVariable("username") String usernmae) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.getPerson(usernmae));
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
    @CrossOrigin(origins="*")
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
    /*
    @GetMapping("/")
	public Iterable<Person> allPersons() {
		try {
			return personService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		}*/
    
}