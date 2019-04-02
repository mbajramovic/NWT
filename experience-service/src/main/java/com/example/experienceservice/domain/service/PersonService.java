package com.example.experienceservice.domain.service;

import java.util.Optional;

import com.example.experienceservice.domain.entity.Person;
import com.example.experienceservice.domain.repository.PersonRepository;

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

    
}