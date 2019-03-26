package com.example.experienceservice.domain.service;


import com.example.experienceservice.domain.entity.Person;
import com.example.experienceservice.domain.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public void newPerson(Person person) {
        personRepository.save(person);
    }

    
}