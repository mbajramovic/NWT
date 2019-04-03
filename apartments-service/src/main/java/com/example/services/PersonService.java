package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Person;
import com.example.repositories.PersonRepository;

/** Klasa predstavlja Service. Za realizaciju potrebnih funkcionalnosti koristi PersonRepository.
 * @author Becic Ajla
*/

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public Iterable<Person> saveAll(List<Person> persons) {
		return personRepository.saveAll(persons);
	}

	public void deleteAll() {
		personRepository.deleteAll();
		
	}
	
	public Iterable<Person> getAll() {
		return personRepository.findAll();
	}
	
	public Optional<Person> getById(Integer id) {
        return personRepository.findById(id);
    }
	
	public void deleteById(Integer id) {
		personRepository.deleteById(id);
	}
}
