package com.example.zuulservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.zuulservice.models.Osoba;
import com.example.zuulservice.service.OsobaService;

@Component
public class Seed implements ApplicationRunner {
    @Autowired
    OsobaService personService;
    PasswordEncoder passwordEncoder;
    
    public void run(ApplicationArguments args) throws Exception {
        try {
        	System.out.println("Hereeeeeeeeeeeeeeeeee");
        	
        	List<Osoba> persons = new ArrayList<Osoba>();
            persons.add(new Osoba("Ajla Becic", "abecic1", "admin", "abecic1@etf.unsa.ba"));
            persons.add(new Osoba("Amera Alic", "aalic1", "admin", "aalic1@etf.unsa.ba"));
            persons.add(new Osoba("Maid Bajramovic", "mbajramovi1", "admin", "mbajramovi1@etf.unsa.ba"));
            
            persons = (List<Osoba>) personService.saveAll(persons);
            
         
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
     }
}
