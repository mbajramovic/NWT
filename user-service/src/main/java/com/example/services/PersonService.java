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

	public Optional<Person> getPerson(Integer id) {
		return personRepository.findById(id);
	}

	public Person findPerson(String username, String password) {
		List<Person> user = personRepository.findPerson(username, password);
		return user.size() > 0 ? user.get(0) : null;
	}
}
