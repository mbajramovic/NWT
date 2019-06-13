package com.example.interactionservice.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.interactionservice.domain.entity.Person;
import com.example.interactionservice.domain.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person newPerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> getPerson(Integer id) {
        return personRepository.findById(id);
    }

    public void deleteUser(Integer id) {
        personRepository.deleteById(id);
    }
    
    public List<Person> getByUsername(String username){
        return personRepository.findByUsername(username);
    }

    
}