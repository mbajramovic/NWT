package com.example.scholarship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.scholarship.domain.entity.Location;
import com.example.scholarship.domain.entity.Scholarship;
import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.service.LocationService;
import com.example.scholarship.domain.service.ScholarshipService;
import com.example.scholarship.domain.service.UserService;

@Component
public class Fill implements ApplicationRunner {
	@Autowired
    ScholarshipService scholarshipService;
    @Autowired
    UserService userService;
    @Autowired
    LocationService locationService;
    
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
        	scholarshipService.deleteAll();
        	userService.deleteAll();
        	locationService.deleteAll();
        	
        	User user1=new User("username1");
        	User user2=new User("username2");
        	List<User> users=new ArrayList<>();
        	users.add(user1);
        	users.add(user2);
        	for (User user : users) {
        		userService.newUser(user);    
            }
        	List<Location> locations = new ArrayList<Location>();
            locations.add(new Location("Elektrotehnicki fakultet", "Sarajevo", "BiH"));
            locations.add(new Location("Medicinski fakultet", "Tuzla", "BiH"));
            Location l=new Location("Filozofski fakultet", "Sarajevo", "BiH");
            locations.add(l);
            for (Location location: locations) {
            	locationService.save(location);
            }
        	
            List<Scholarship> scholarships = new ArrayList<>();
            scholarships.add(new Scholarship("Tekst vezan za stipendiju", "www.stipendija1.com", user1, "27/03/2019", l));
            scholarships.add(new Scholarship("Tekst vezan za stipendiju2", "www.stipendija2.com", user1, "27/03/2019", l ));
            scholarships.add(new Scholarship("Tekst vezan za stipendiju3", "www.stipendija1.com", user2,"27/03/2019", l ));
            
            for (Scholarship scholarship : scholarships) {
            	scholarshipService.newScholarship(scholarship);
                
                
            }
  
            Iterable<Scholarship> allSC = scholarshipService.getAll();
            for (Scholarship scholarship : allSC) {
                System.out.println(scholarship.toString());
            }

         
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
     }
}