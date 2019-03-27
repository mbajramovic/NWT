package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOCATION")
public class Location {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOC_SEQ")
    @SequenceGenerator(sequenceName = "location_seq", allocationSize = 1, initialValue=100, name = "LOC_SEQ")
    private Integer id;
	
	@Column(name = "adress")
	private String adress;

	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	public Location() {}
	
	public Location(String adress, String city, String country) {
		super();
		this.id = 0;
		this.adress = adress;
		this.city = city;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
