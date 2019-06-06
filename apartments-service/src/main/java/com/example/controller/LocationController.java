package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.models.Location;
import com.example.services.LocationService;

/** Klasa predstavlja RestController. Implementira potrebne rute za manipulaciju podacima o lokacijama.
 * @author Becic Ajla
*/

@RestController
public class LocationController {
	@Autowired
	LocationService locationService;
    
	/** Ruta za dobavljanje svih lokacija.
     * @return Lista oglasa tipa Iterable<Location>
    */
	@CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/locations")
    public ResponseEntity getLocations() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(locationService.getAll());
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    /** Ruta za dobavljanje jedne lokacije, na osnovu ID-a koji se salje kao parametar.
     * @param id id lokacije.
     * @return Location ako je pronadjen u bazi, null ako nije.
    */
	@CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/location/{id}")
    public ResponseEntity getLocationById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(locationService.getById(id));
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
	
	@CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/location/countries")
    public ResponseEntity getLocationsDistinct() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(locationService.getLocationsDistinct());
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
    
    /** Ruta za testiranje spremanja korisnika u bazu.
    */    
	@CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/location", consumes = "application/json")
    public ResponseEntity saveLocation(@RequestBody Location location) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(locationService.save(location));
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request", ex);
        }
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE, value="/location/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        try {
        	locationService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
}
