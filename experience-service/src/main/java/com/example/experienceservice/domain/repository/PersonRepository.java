package com.example.experienceservice.domain.repository;


import com.example.experienceservice.domain.entity.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
    @Modifying
    @Transactional
    @Query
        ("delete from Person u where u.userId = :userId")
    public void deletePersonByUserId(@Param("userId") Integer userId);
}