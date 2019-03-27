package com.example.scholarship.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholarship.domain.entity.Location;
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

}
