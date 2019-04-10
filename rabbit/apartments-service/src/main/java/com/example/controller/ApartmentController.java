package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Apartment;
import com.example.services.ApartmentService;
import com.example.services.LocationService;
import com.example.services.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Klasa predstavlja RestController. Implementira potrebne rute za manipulaciju
 * podacima o oglasima za smjestaj.
 * 
 * @author Becic Ajla
 */

@RestController
public class ApartmentController {
	@Autowired
	ApartmentService apartmentService;
	@Autowired
	LocationService locationService;
	@Autowired
	PersonService personService;
	ObjectMapper mapper = new ObjectMapper();

	/**
	 * Ruta za dobavljanje svih oglasa za stanovanje.
	 * 
	 * @return Lista oglasa tipa Iterable<Apartment>
	 */
	@GetMapping("/getApartments")
	public Iterable<Apartment> getApartments() {
		return apartmentService.getAll();
	}

	/**
	 * Ruta za dobavljanje jednog oglasa iz baze, na osnovu ID-a koji se salje kao
	 * parametar.
	 * 
	 * @param id id oglasa za smjestaj.
	 * @return Apartment ako je pronadjen u bazi, null ako nije.
	 */
	@GetMapping("/getApartmentById")
	public Optional<Apartment> getApartmentById(@RequestParam(value = "id") Integer id) {
		return apartmentService.getById(id);
	}
	
	/**
	 * Ruta za dobavljanje svih apartmana na odreðenoj lokaciji
	 */
	@GetMapping("/getAllByLocation")
	public Iterable<Apartment> getAllByLocation(@RequestParam(value = "id") Integer id) {
		return apartmentService.getAllByLocation(id);
	}

	/**
	 * Ruta za testiranje spremanja oglasa u bazu.
	 */
	@GetMapping("/apartmentSave")
	public String saveApartment(@RequestParam(value = "location") String location,
			@RequestParam(value = "person") String person, @RequestParam(value = "title") String title) {
		Apartment apartment = new Apartment();

		try {
			Integer lok = Integer.valueOf(location);
			Integer per = Integer.valueOf(person);
			
			apartment.setLocation(locationService.getById((Integer) lok).get());
			apartment.setPerson(personService.getById((Integer) per).get());
			apartment.setTitle(title);
			try {
				apartmentService.save(apartment);
				return mapper.writeValueAsString(apartmentService.save(apartment));
			} catch (Exception e) {
				return e.getLocalizedMessage();
			}
		} catch (Exception e1) {

			apartment.setLocation(locationService.getById(null).get());
			apartment.setPerson(personService.getById(null).get());
			try {
				apartmentService.save(apartment);
				return mapper.writeValueAsString(apartmentService.save(apartment));
			} catch (Exception e) {
				return e.getLocalizedMessage();
			}
		}
	}

	@GetMapping("/deleteApartmentById")
	public void deleteById(@RequestParam(value = "id") Integer id) {
		apartmentService.deleteById(id);
	}
}
