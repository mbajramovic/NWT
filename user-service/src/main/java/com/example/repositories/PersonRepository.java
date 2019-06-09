package com.example.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.example.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{
    @Query
        ("select u from Person u where u.username = :username and u.password = :password")
    public List<Person> findPerson(@Param("username")String username, @Param("password")String password);

    public Optional<Person> findByUsername(String username);
}
