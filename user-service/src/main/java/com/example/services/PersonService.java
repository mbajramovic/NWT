package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Person;
import com.example.repositories.PersonRepository;


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

	public void deleteUser(Integer id) {
		personRepository.deleteById(id);
	}

	public Optional<Person> getPerson(String username) {
		return personRepository.findByUsername(username);
	}

	public Person findPerson(String username, String password) {
		List<Person> user = personRepository.findPerson(username, password);
		return user.size() > 0 ? user.get(0) : null;
	}
	public Person update(Person newUser, Integer id) throws Exception {
    	return personRepository.findById(id)
		.map(person -> {
			person.setUsername(newUser.getUsername());
			return personRepository.save(person);
		}).orElseGet(() -> {
			newUser.setId(id);
			return personRepository.save(newUser);
		});
    }

	
		public List<Person> getAll() throws Exception {
	        return (List<Person>) personRepository.findAll();
	    }
	
}
