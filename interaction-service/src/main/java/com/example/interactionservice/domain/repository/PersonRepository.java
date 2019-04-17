package com.example.interactionservice.domain.repository;

import javax.transaction.Transactional;

import com.example.interactionservice.domain.entity.Person;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends CrudRepository<Person, Integer>{
 
   
    @Modifying
    @Transactional
    @Query
        ("delete from Person u where u.userId = :userId")
    public void deletePersonByUserId(@Param("userId") Integer userId);
}