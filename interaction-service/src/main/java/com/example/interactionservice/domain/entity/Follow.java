package com.example.interactionservice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @NotNull
    @JoinColumn(referencedColumnName =  "id", nullable = false)
    private Person user;

    @ManyToOne
    @NotNull
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Person followedUser;

    public Follow() {}

    public Follow(Person user, Person followedUser) {
        this.user = user;
        this.followedUser = followedUser;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public Person getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Person user) {
        this.user = user;
    }

    /**
     * @return the followedUser
     */
    public Person getFollowedUser() {
        return followedUser;
    }

    /**
     * @param followedUser the followedUser to set
     */
    public void setFollowedUser(Person followedUser) {
        this.followedUser = followedUser;
    }

    @Override
    public String toString() {
        return "**User with username " + this.user.getUsername() + " is following the user with username " + this.followedUser.getUsername() + "**\n";
    }

    
}