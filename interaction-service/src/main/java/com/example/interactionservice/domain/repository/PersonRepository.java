package com.example.interactionservice.domain.repository;

import com.example.interactionservice.domain.entity.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
    
}