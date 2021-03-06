package com.example.experienceservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.experienceservice.domain.entity.Comment;
import com.example.experienceservice.domain.entity.Experience;
import com.example.experienceservice.domain.entity.Person;
import com.example.experienceservice.domain.service.CommentService;
import com.example.experienceservice.domain.service.ExperienceService;
import com.example.experienceservice.domain.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Seed implements ApplicationRunner {
    @Autowired
    ExperienceService experienceService;
    @Autowired
    CommentService commentService;
    @Autowired
    PersonService personService;
    
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            List<Person> users = new ArrayList<>();
            users.add(new Person("abecic", 3));
            users.add(new Person("mbajramovic", 1));
            users.add(new Person("aalic", 2));
            Integer i = 0;
            for (Person user : users) {
                personService.newPerson(user);
            }
            
            List<Experience> experiences = new ArrayList<>();
            experiences.add(new Experience(1, "My experience is written here (: Comment me, please.", "My first experience", users.get(0), new Date(2019,3,25)));
            experiences.add(new Experience(2, "One more experience is written here (: Comment me, please.", "About me...", users.get(1), new Date(2019,3,25)));
            experiences.add(new Experience(3, "Last one experience is written here (: Comment me, please.", "Hello,..", users.get(2), new Date(2019,3,25)));
            i = 0;
            for (Experience experience : experiences) {
                experienceService.newExperience(experience);
                
                Comment comment = i % 2 == 0 ? new Comment(i+1, "My comment about your precious experience is written here", users.get(2-i), new Date(2019, 3, 25)) :
                                               new Comment(i+1, "My comment about your terrible experience is written here", users.get(0), new Date(2019, 3, 25));
                i++;
                comment.setExperience(experience);
                commentService.newComment(comment);
                
            }
            /*Iterable<Experience> allExperiences = experienceService.getAll();
            for (Experience experience : allExperiences) {
                System.out.println(experience.toString());
            }*/

           Iterable<Comment> allComments = commentService.getAll();
            for (Comment comment : allComments) {
                System.out.println(comment.toString());
            }

         
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
     }
}