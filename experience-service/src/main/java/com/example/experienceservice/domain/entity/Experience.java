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
@Table(name="experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(max=1000)
    private String text;

    @NotNull
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Person user;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date postDate;

    public Experience() {

    }

    public Experience(Integer id, String text, Person user, Date postDate) {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "Experience id: " + this.id + "\nText: " + this.text + "\nUser: " + this.user.getUsername() + "\nPost date: " + this.postDate.toString() + "\n";
    }
    
}