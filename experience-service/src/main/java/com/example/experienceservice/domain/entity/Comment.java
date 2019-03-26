package com.example.experienceservice.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Size(max=500)
    private String text;

    @NotNull
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Person user;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date postDate;

    @ManyToOne
    @JoinColumn(name="experienceId", nullable=false)
    private Experience experience;

    public Comment() {

    }

    public Comment(Integer id, String text, Person user, Date postDate) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.postDate = postDate;
    }

    public Integer getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public Person getUser() {
        return this.user;
    }

    public Date getPostDate() {
        return this.postDate;
    }

    public Experience getExperience() {
        return this.experience;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUserId(Person user) {
        this.user = user;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Experience: " + this.experience.getText() + "\nExperience Author: " + this.experience.getUser().getUsername() +  "\n     Comment text: " + this.text + "\n     Comment Author: " + this.user.getUsername() + "\n     Post date: " + this.postDate.toString() + "\n";
    }

}