package com.example.scholarship.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholarship.domain.entity.Location;
import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.exception.EntityNotFoundException;
import com.example.scholarship.domain.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	LocationRepository locationRepository;
	
	public Location save(Location location) throws EntityNotFoundException {
		return locationRepository.save(location);
	}
	
	public Iterable<Location> saveAll(List<Location> locations) throws EntityNotFoundException {
		return locationRepository.saveAll(locations);
	}

	public void deleteAll() throws EntityNotFoundException {
		locationRepository.deleteAll();
		
	}
	
	public Iterable<Location> getAll() throws EntityNotFoundException {
		return locationRepository.findAll();
	}
	public Optional<Location> getById(Integer id) throws EntityNotFoundException {
		return locationRepository.findById(id);
	}
	
	public void deleteById (Integer id) throws EntityNotFoundException {
		locationRepository.deleteById(id);
	}

	public void update(Location newLocation, Integer id) throws EntityNotFoundException {
    	locationRepository.findById(id)
		.map(location -> {
			location.setCity(newLocation.getCity());
			location.setCountry(newLocation.getCountry());
			location.setUniversity(newLocation.getUniversity());
			return locationRepository.save(location);
		}).orElseGet(() -> {
			newLocation.setId(id);
			return locationRepository.save(newLocation);
		});
    }
}
