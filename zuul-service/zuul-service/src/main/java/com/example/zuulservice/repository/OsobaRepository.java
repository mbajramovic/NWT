package com.example.zuulservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.zuulservice.models.Osoba;

import java.util.List;
import java.util.Optional;

@Repository
public interface OsobaRepository extends CrudRepository<Osoba, Integer>{
    @Query
        ("select u from Osoba u where u.username = :username and u.password = :password")
    public List<Osoba> findPerson(@Param("username")String username, @Param("password")String password);
    @Query
    	("select u from Osoba u where u.username = :username")
    public Optional<Osoba> findOneByUsername(@Param("username")String username);

}
