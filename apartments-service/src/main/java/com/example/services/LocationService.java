package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Location;
import com.example.repositories.LocationRepository;

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
