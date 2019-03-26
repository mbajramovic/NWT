package com.example.experienceservice.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(max=1000)
    private String text;

    @NotNull
    private Integer userId;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date postDate;

    public Experience() {

    }

    public Experience(Integer id, String text, Integer userId, Date postDate) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.postDate = postDate;
    }

    public Integer getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public Integer getUserId() {
        return this.userId;
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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "Experience id: " + this.id + "\nText: " + this.text + "\nUser id: " + this.userId + "\nPost date: " + this.postDate.toString() + "\n";
    }
    
}