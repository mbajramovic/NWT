package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Person;


public interface PersonRepository extends CrudRepository<Person, Integer>{

}
