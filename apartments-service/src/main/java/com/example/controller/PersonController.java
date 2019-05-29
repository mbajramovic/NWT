package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.models.Person;
import com.example.services.PersonService;

/** Klasa predstavlja RestController. Implementira potrebne rute za manipulaciju podacima o korisniku.
 * @author Becic Ajla
*/

@RestController
public class PersonController {
	@Autowired
	PersonService personService;
    
	/** Ruta za dobavljanje svih korisnika.
     * @return Lista oglasa tipa Iterable<Person>
    */
	@CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/persons")
    public ResponseEntity getPersons() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.getAll());
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    /** Ruta za dobavljanje jednog korisnika, na osnovu ID-a koji se salje kao parametar.
     * @param id id korisnika.
     * @return Person ako je pronadjen u bazi, null ako nije.
    */
	@CrossOrigin(origins = "*")
    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public ResponseEntity getPersonById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.getById(id));
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
	
	@CrossOrigin(origins = "*")
    /** Ruta za testiranje spremanja korisnika u bazu.
    */
    @RequestMapping(method=RequestMethod.POST, value="")
    public ResponseEntity savePerson(@RequestBody Person person) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.save(person));
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        try {
        	personService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
}
