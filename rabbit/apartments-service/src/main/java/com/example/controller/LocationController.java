package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/getLocations")
    public Iterable<Location> getLocations() {
        return locationService.getAll();
    }

    /** Ruta za dobavljanje jedne lokacije, na osnovu ID-a koji se salje kao parametar.
     * @param id id lokacije.
     * @return Location ako je pronadjen u bazi, null ako nije.
    */
    @GetMapping("/getLocationById")
    public Optional<Location> getLocationById(@RequestParam(value="id") Integer id) {
        return locationService.getById(id);
    }
    
    /** Ruta za testiranje spremanja korisnika u bazu.
    */
    @GetMapping("/locationSave")
    public void saveLocation() {
    	Location location = new Location();
    	//korisnik.setId(77);
    	locationService.save(location);
    }
    
    @GetMapping("/deleteLocationById")
    public void deleteById(@RequestParam(value="id") Integer id) {
    	locationService.deleteById(id);
    }
}
