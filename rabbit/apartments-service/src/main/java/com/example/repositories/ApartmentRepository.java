package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Apartment;

@Repository
public interface ApartmentRepository  extends CrudRepository<Apartment, Integer>{
	public List<Apartment> findByLocation(Integer id);
}
