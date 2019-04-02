package com.example.experienceservice.resources;

import com.example.experienceservice.domain.entity.Person;
import com.example.experienceservice.domain.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class PersonController {
    @Autowired
    PersonService personService; 

    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public ResponseEntity getUser(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.getPerson(id));
        }
        catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id) {
        try {
            personService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method=RequestMethod.POST, value="/new")
    public ResponseEntity addUser(@RequestBody Person person) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.newPerson(person));
        }
        catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        }
    }
}