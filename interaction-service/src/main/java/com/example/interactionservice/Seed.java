package com.example.interactionservice;

import java.util.ArrayList;
import java.util.List;

import com.example.interactionservice.domain.entity.Follow;
import com.example.interactionservice.domain.entity.Message;
import com.example.interactionservice.domain.entity.Person;
import com.example.interactionservice.domain.service.FollowService;
import com.example.interactionservice.domain.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Seed implements ApplicationRunner {
    @Autowired
    PersonService personService;
    @Autowired
    FollowService followService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            List<Person> users = new ArrayList<>();
            users.add(new Person("mbajramovic", 1));
            users.add(new Person("aalic", 2));
            users.add(new Person("abecic", 3));

            for (Person user : users) {
                personService.newPerson(user);
            }

            List<Follow> followActions = new ArrayList<>();
            followActions.add(new Follow(users.get(0), users.get(1)));
            followActions.add(new Follow(users.get(0), users.get(2)));
            followActions.add(new Follow(users.get(1), users.get(2)));
            followActions.add(new Follow(users.get(2), users.get(0)));
            for (Follow followAction : followActions) {
                followService.newFollowAction(followAction);
            }

            Iterable<Follow> followDetails = followService.getAllFollowDetails();
            for (Follow detail : followDetails) {   
                System.out.println(detail.toString());
            }

            List<Message> messages = new ArrayList<>();
            messages.add(new Message(users.get(0), users.get(2), "Hello Ajla, Maid here :)"));
            messages.add(new Message(users.get(2), users.get(0), "Hello Maid, Ajla here (:"));
            messages.add(new Message(users.get(1), users.get(0), "Hello Maid, how are you today? Greetings, Amera!"));
            messages.add(new Message(users.get(0), users.get(1), "Amera, I am fine, thank u"));
            messages.add(new Message(users.get(2), users.get(1), "Amera, why don't u ask how i am today??? Angry, Ajla."));
            for (Message message : messages) {
                System.out.println(message.toString());
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}