package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/getPersons")
    public Iterable<Person> getPersons() {
        return personService.getAll();
    }

    /** Ruta za dobavljanje jednog korisnika, na osnovu ID-a koji se salje kao parametar.
     * @param id id korisnika.
     * @return Person ako je pronadjen u bazi, null ako nije.
    */
    @GetMapping("/getPersonById")
    public Optional<Person> getPersonById(@RequestParam(value="id") Integer id) {
        return personService.getById(id);
    }
    
    /** Ruta za testiranje spremanja korisnika u bazu.
    */
    @GetMapping("/personSave")
    public void savePerson() {
    	Person person = new Person();
    	//korisnik.setId(77);
    	personService.save(person);
    }
    
    @GetMapping("/deletePersonById")
    public String deleteById(@RequestParam(value="id") Integer id) {
    	personService.deleteById(id);
    	return "Korisnik je usmjesno obrisan";
    }
}
