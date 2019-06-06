package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	@RequestMapping(method = RequestMethod.GET, value = "/apartments")
    public ResponseEntity getApartments() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(apartmentService.getAll());
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

	/**
	 * Ruta za dobavljanje jednog oglasa iz baze, na osnovu ID-a koji se salje kao
	 * parametar.
	 * 
	 * @param id id oglasa za smjestaj.
	 * @return Apartment ako je pronadjen u bazi, null ako nije.
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/apartment/{id}")
	    public ResponseEntity getApartmentById(@PathVariable("id") Integer id) {
	        try {
	            return ResponseEntity.status(HttpStatus.OK).body(apartmentService.getById(id));
	        }
	        catch(Exception ex) {
	            System.out.println(ex.getLocalizedMessage());
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
	        }
	    }
	
	/**
	 * Ruta za dobavljanje svih apartmana na odre�enoj lokaciji
	 */	
	@RequestMapping(method= RequestMethod.GET, value="/location/{locationId}/apartment")
    public ResponseEntity getAllByLocation(@PathVariable("locationId") Integer locationId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(apartmentService.getAllByLocation(locationId));
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

	/**
	 * Ruta za testiranje spremanja oglasa u bazu.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/apartment", consumes = "application/json")
    public ResponseEntity saveApartment(@RequestBody Apartment apartment) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(apartmentService.save(apartment));
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request", ex);
        }
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value="/apartment/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        try {
        	apartmentService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
}
