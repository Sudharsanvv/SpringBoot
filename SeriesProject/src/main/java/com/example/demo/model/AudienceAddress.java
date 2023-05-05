package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="spectatorsaddress")
	public class AudienceAddress 
	{
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    private String street;
	    private String city;
	    private String zipCode;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
		@Override
		public String toString() {
			return "AudienceAddress [id=" + id + ", street=" + street + ", city=" + city + ", zipCode=" + zipCode + "]";
		}
		
	}
	    