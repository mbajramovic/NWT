package com.example.interactionservice.domain.service;

import java.util.List;

import com.example.interactionservice.domain.entity.Follow;
import com.example.interactionservice.domain.entity.Person;
import com.example.interactionservice.domain.repository.FollowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    @Autowired
    FollowRepository followRepository;
        
    public Follow newFollowAction(Follow follow) throws Exception {
        try {
            if (follow.getUser().getId() != follow.getFollowedUser().getId())
                return followRepository.save(follow);
            else
                throw new Exception("User can not be followed by himself.");

        }
        catch(Exception ex) {
            throw ex;
        }
    }

    public Iterable<Follow> getAllFollowDetails() {
        return followRepository.findAll();
    }

    public Follow getFriendship(Integer follower, Integer following) {
        return followRepository.getFriendship(follower, following);
    }

    public void unfollow(Integer follower, Integer following)  {
        try {
            Follow follow = this.getFriendship(follower, following);
            if (follow != null)
                followRepository.delete(follow);
            else
                throw new IllegalArgumentException("Unexisting friendship");
        }
        catch(IllegalArgumentException ex) {
            throw ex;
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    public List<Person> getFollowers(Integer userId) {
        return followRepository.getFollowers(userId);
    }

    public List<Person> following(Integer userId) {
        return followRepository.following(userId);
    }
}