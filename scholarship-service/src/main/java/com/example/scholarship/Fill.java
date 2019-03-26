package com.example.scholarship;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.scholarship.domain.entity.Scholarship;
import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.service.ScholarshipService;
import com.example.scholarship.domain.service.UserService;

@Component
public class Fill implements ApplicationRunner {
	@Autowired
    ScholarshipService scholarshipService;
    @Autowired
    UserService userService;
    
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
        	scholarshipService.deleteAll();
        	userService.deleteAll();
        	User user1=new User(1, "username1");
        	User user2=new User(2, "username2");
        	List<User> users=new ArrayList<>();
        	users.add(user1);
        	users.add(user2);
        	for (User user : users) {
        		userService.newUser(user);
                
                
            }
        	
        	
            List<Scholarship> scholarships = new ArrayList<>();
            scholarships.add(new Scholarship(1, "Tekst vezan za stipendiju", "www.stipendija1.ba", user1));
            scholarships.add(new Scholarship(2, "Tekst vezan za stipendiju", "www.stipendija2.com", user1 ));
            scholarships.add(new Scholarship(3, "Tekst vezan za stipendiju", "www.stipendija1.de", user2 ));
            
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