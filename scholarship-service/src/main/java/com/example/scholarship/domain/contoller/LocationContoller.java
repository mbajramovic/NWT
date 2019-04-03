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
import com.example.scholarship.domain.service.LocationService;

@RestController
public class LocationContoller {
	
	@Autowired
	LocationService locationService;
	
	@PostMapping("/locationSave")
	public ResponseEntity saveLocation(@RequestBody Location location) {
		try {
			locationService.save(location);
			return ResponseEntity.status(HttpStatus.OK).body("Uspješno dodana lokacija");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
		
	@GetMapping("/locations")
	public ResponseEntity allLocations() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(locationService.getAll());
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		 }
	
	@GetMapping("/location")
	public ResponseEntity getLocation (@RequestParam(value="id") Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(locationService.getById(id));
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@DeleteMapping ("/locationsDelete")
	public ResponseEntity deleteLocations() {
		try {
			locationService.deleteAll();
			return ResponseEntity.status(HttpStatus.OK).body("Lokacije uspjesno obrisane");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@DeleteMapping("/locationDelete")
	public ResponseEntity deleteLocation (@RequestParam(value="id") Integer id) {
		try {
			locationService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Lokacija uspjesno obrisana");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	
	@PutMapping("/locationUpdate/{id}")
	public ResponseEntity replaceLocation(@RequestBody Location newLocation, @PathVariable Integer id) {
		try {
			locationService.update(newLocation, id);
			return ResponseEntity.status(HttpStatus.OK).body("Lokacija uspjesno azurirana");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
}
