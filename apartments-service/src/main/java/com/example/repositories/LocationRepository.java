package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>{
	
	@Query("SELECT DISTINCT p.country FROM Location p")
	Iterable<String> findDistinctByCountry();
}
