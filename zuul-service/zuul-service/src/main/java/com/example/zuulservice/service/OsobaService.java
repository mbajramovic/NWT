package com.example.zuulservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.zuulservice.exception.EntityNotFoundException;
import com.example.zuulservice.models.Osoba;
import com.example.zuulservice.repository.OsobaRepository;
import com.example.zuulservice.response.JWTTokenResponse;

@Service
public class OsobaService {

	@Autowired
	OsobaRepository personRepository;
	
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenService jwtTokenService;
	
	public Osoba save(Osoba person) {
		return personRepository.save(person);
	}
	
	public Iterable<Osoba> saveAll(List<Osoba> persons) {
		return personRepository.saveAll(persons);
	}

	public void deleteAll() {
		personRepository.deleteAll();
		
	}

	public void deleteUser(Integer id) {
		personRepository.deleteById(id);
	}

	public Optional<Osoba> getPerson(Integer id) {
		return personRepository.findById(id);
	}

	public Osoba findPerson(String username, String password) {
		List<Osoba> user = personRepository.findPerson(username, password);
		return user.size() > 0 ? user.get(0) : null;
	}
	public Osoba update(Osoba newUser, Integer id) throws Exception {
    	return personRepository.findById(id)
		.map(person -> {
			person.setUsername(newUser.getUsername());
			return personRepository.save(person);
		}).orElseGet(() -> {
			newUser.setId(id);
			return personRepository.save(newUser);
		});
    }

	
	public List<Osoba> getAll() throws Exception {
		return (List<Osoba>) personRepository.findAll();
	}
	
	public JWTTokenResponse generateJWTToken(String username, String password) {
		System.out.println("evo u servisu");
        return personRepository.findOneByUsername(username)
                .filter(person ->  ( password.equals(person.getPassword()) ))
                .map(person -> new JWTTokenResponse(jwtTokenService.generateToken(username)))
                .orElseThrow(() ->  new EntityNotFoundException("Account not found"));
    }

	
	
}
