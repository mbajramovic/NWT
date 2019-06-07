package com.example.scholarship.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="locations")
	public class Location {
		
		private static final String pattern="^[A-Z].*"; 
		//da pocinje velikim slovom
	
		@NotNull
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		
		
		@Size(min=3) //provjeriti
		@Column(name = "university")
		private String university;
		
		@NotNull
		@Size(min=3)
		@Column(name = "city")
		private String city;
		
		@NotNull
		@Size(min=2)
		@Column(name = "country")
		private String country;
		
		public Location() {}
		
		public Location(String university, String city, String country) {
			
			if(university.matches(pattern)) this.university = university;
			if(city.matches(pattern)) this.city = city;
			if(country.matches(pattern)) this.country = country;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUniversity() {
			return university;
		}

		public void setUniversity(String university) {
			if(university.matches(pattern)) this.university = university;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			if(city.matches(pattern)) this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			if(country.matches(pattern)) this.country = country;
		}

}
