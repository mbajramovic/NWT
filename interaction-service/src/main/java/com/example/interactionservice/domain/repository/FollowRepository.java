package com.example.interactionservice.domain.repository;

import java.util.List;

import com.example.interactionservice.domain.entity.Follow;
import com.example.interactionservice.domain.entity.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FollowRepository extends CrudRepository<Follow, Integer> {
    
    @Query
        ("select f from Follow f where f.user.id = :follower and f.followedUser.id = :following")
    public Follow getFriendship(@Param("follower") Integer follower, @Param("following") Integer following);

    @Query 
        ("select u from Person u, Follow f where u.id = f.user.id and f.followedUser.id = :userId")
    public List<Person> getFollowers(@Param("userId") Integer userId);

    @Query
        ("select u from Person u, Follow f where u.id = f.followedUser.id and f.user.id = :userId")
    public List<Person> following(@Param("userId") Integer userId);
}