package com.example.interactionservice.domain.repository;

import com.example.interactionservice.domain.entity.Person;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	
	List<Person> findByUsername(String username);
    
}