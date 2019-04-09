package com.example.scholarship.domain.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.scholarship.domain.entity.Location;
import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.exception.EntityNotFoundException;
import com.example.scholarship.domain.service.LocationService;

@RestController
@RequestMapping(value = "/location")
public class LocationContoller {
	
	@Autowired
	LocationService locationService;
	
	@PostMapping("")
	public Location saveLocation(@RequestBody Location location) {
		try {
			return locationService.save(location);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return location;
		
	}
		
	@GetMapping("/")
	public Iterable<Location> getAllLocations() {
		try {
			return locationService.getAll();
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		 }
	
	@GetMapping("")
	public Optional<Location> getLocation (@RequestParam(value="id") Integer id) {
		try {
			return locationService.getById(id);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		}
	
	@DeleteMapping ("/")
	public void deleteAllLocations() {
		try {
			locationService.deleteAll();
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
	@DeleteMapping("")
	public void deleteLocation (@RequestParam(value="id") Integer id) {
		try {
			locationService.deleteById(id);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
	
	@PutMapping("")
	public void replaceLocation(@RequestBody Location newLocation, @PathVariable Integer id) {
		try {
			locationService.update(newLocation, id);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
}
