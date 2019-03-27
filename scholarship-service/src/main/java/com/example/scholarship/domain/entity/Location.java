package com.example.scholarship.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locations")
	public class Location {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		
		@Column(name = "university")
		private String university;

		@Column(name = "city")
		private String city;
		
		@Column(name = "country")
		private String country;
		
		public Location() {}
		
		public Location(Integer id,String university, String city, String country) {
			super();
			this.id = id;
			this.university = university;
			this.city = city;
			this.country = country;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUniverity() {
			return university;
		}

		public void setUniversity(String university) {
			this.university = university;
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
