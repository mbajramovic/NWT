package com.example.scholarship.domain.entity;

import java.sql.Date;
import java.util.regex.Pattern;

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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="scholarships")
public class Scholarship {
	
	private static final String patternTekst="^[A-Z].*"; 
	//da počinje velikim slovom
	private static final String patternLink="^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$"; 
	//validna internet adresa
	private static final String patternDate="^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
	//validan format datuma kao dd/mm/yyyy
	
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(max=2000)
	@Column(name="text")
	private String text;
	
	
	@Column(name="link")
	private String link;

	@NotNull
	@ManyToOne
	@JoinColumn(name="userId", nullable=false)
	private User user;
	
	@Column(name = "postDate")
	private String date;

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		if(date.matches(patternDate)) this.date = date;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


	@ManyToOne
	@JoinColumn(name="locationId", nullable=false)
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
		if(text.matches(patternTekst)) this.text = text;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		if(link.matches(patternLink)) this.link = link;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Scholarship(String text, String link, User user, String date, Location location) {
		super();
		this.id = id;
		if(text.matches(patternTekst))this.text = text;
		this.link = link;
		this.user = user;
		if(date.matches(patternDate)) this.date = date;
		this.location = location;
	}

	
	@Override
	public String toString() {
		return "Scholarship: " +this.getText() + "\n Link: "+
	this.getLink()+"\n Published user: "+ this.user.getUsername()+
	"\n Published date: "+ this.getDate()+
	"\n Location: "+this.getLocation().getUniversity();
	}

}
