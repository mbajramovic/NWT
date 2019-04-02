package com.example.interactionservice.resources;

import com.example.interactionservice.domain.entity.Follow;
import com.example.interactionservice.domain.service.FollowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    FollowService followService;

    @RequestMapping(method = RequestMethod.POST, value="/new")
    public ResponseEntity follow(@RequestBody Follow follow) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(followService.newFollowAction(follow));
        }
        catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/unfollow/{follower}/{following}")
    public ResponseEntity unfollow(@PathVariable("follower") Integer follower, @PathVariable("following") Integer following) {
        try {
            followService.unfollow(follower, following);
            return ResponseEntity.status(HttpStatus.OK).body("unfollowed");
        }
        catch(IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());

        }
        catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        } 
    }

    @RequestMapping(method = RequestMethod.GET, value="/followers/{userId}")
    public ResponseEntity getFollowers(@PathVariable("userId") Integer userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(followService.getFollowers(userId));
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        }
    }

    
    @RequestMapping(method = RequestMethod.GET, value="/following/{userId}")
    public ResponseEntity following(@PathVariable("userId") Integer userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(followService.following(userId));
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        }
    }
    

}