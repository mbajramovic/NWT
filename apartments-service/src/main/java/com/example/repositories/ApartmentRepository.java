package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Apartment;

@Repository
public interface ApartmentRepository  extends CrudRepository<Apartment, Integer>{

}
