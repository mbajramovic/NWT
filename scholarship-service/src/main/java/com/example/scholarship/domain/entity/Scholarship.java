package com.example.scholarship.domain.entity;

import java.sql.Date;

import javax.persistence.Column;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="scholarships")
public class Scholarship {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="text")
	private String text;
	
	@Column(name="link")
	private String link;

	
	@ManyToOne
	@JoinColumn(name="userId", nullable=false)
	private User user;
	
	
	@Column(name = "postDate")
	private String date;


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


	@ManyToOne
	@JoinColumn(name="location_id", nullable=false)
	private Location location;

	public Scholarship() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Scholarship(Integer id, String text, String link, User user, String date, Location location) {
		super();
		this.id = id;
		this.text = text;
		this.link = link;
		this.user = user;
		this.date = date;
		this.location = location;
	}

	
	@Override
	public String toString() {
		return "Scholarship: " +this.getText() + "\n Link: "+
	this.getLink()+"\n Published user: "+ this.user.getUsername()+
	"\n Published date: "+ this.getDate()+
	"\n Location: "+this.getLocation().getUniverity();
	}

}
