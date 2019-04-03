package com.example.scholarship.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholarship.domain.entity.Location;
import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	LocationRepository locationRepository;
	
	public Location save(Location location) {
		return locationRepository.save(location);
	}
	
	public Iterable<Location> saveAll(List<Location> locations) {
		return locationRepository.saveAll(locations);
	}

	public void deleteAll() {
		locationRepository.deleteAll();
		
	}
	
	public Iterable<Location> getAll() {
		return locationRepository.findAll();
	}
	public Optional<Location> getById(Integer id) {
		return locationRepository.findById(id);
	}
	
	public void deleteById (Integer id) {
		locationRepository.deleteById(id);
	}

	public void update(Location newLocation, Integer id) {
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
