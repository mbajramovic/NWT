package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Location;
import com.example.repositories.LocationRepository;

/** Klasa predstavlja Service. Za realizaciju potrebnih funkcionalnosti koristi LocationRepository.
 * @author Becic Ajla
*/

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
	
	public Iterable<String> getLocationsDistinct() {
        return locationRepository.findDistinctByCountry();
    }
	
	public void deleteById(Integer id) {
		locationRepository.deleteById(id);
	}

}
