package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.exception.EntityNotFoundException;
import com.example.models.Person;
import com.example.repositories.PersonRepository;
import com.example.response.JWTTokenResponse;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenService jwtTokenService;
	
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
	
	public JWTTokenResponse generateJWTToken(String username, String password) {
		System.out.println("evo u servisu");
        return personRepository.findOneByUsername(username)
                .filter(person ->  ( password.equals(person.getPassword()) ))
                .map(person -> new JWTTokenResponse(jwtTokenService.generateToken(username)))
                .orElseThrow(() ->  new EntityNotFoundException("Account not found"));
    }

	
	
}
