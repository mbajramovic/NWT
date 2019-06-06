package com.example.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="APARTMENT")
public class Apartment {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AP_SEQ")
    @SequenceGenerator(sequenceName = "apartment_seq", allocationSize = 1, initialValue=100, name = "AP_SEQ")
    private Integer id;
	
	@Column(name = "description")
	@Size(max = 500, message="Opis ne može biti duži od 500 karaktera.")
	private String description;

	@Column(name = "title")
	@Size(max =50, message="Naslov ne može biti duži od 50 karaktera.")
	private String title;
	
	@ManyToOne
	 @JoinColumn(name="person_id", nullable=false)
	@NotNull
	private Person person;
	
	@ManyToOne
	 @JoinColumn(name="location_id", nullable=false)
	@NotNull
	private Location location;

	/*@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "postDate")
	private Date date;*/
	
	public Apartment() {
	}
	
	
	public Apartment(String description, String title, Person person, Location location, Date date) {
		super();
		this.description = description;
		this.title = title;
		this.person = person;
		this.location = location;
		//this.date = date;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	/*public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}*/
}
