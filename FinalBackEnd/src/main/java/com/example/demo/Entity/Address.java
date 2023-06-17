package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Address //child class
{
   @Id
   @GeneratedValue
   private Long id;
   private String street;
   private String city;
   private String ZipCode;
public Long getId() {
	return id;
}
public void setId(Long id) {
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
	return ZipCode;
}
public void setZipCode(String zipCode) {
	ZipCode = zipCode;
}
@Override
public String toString() {
	return String.format("Address [id=%s, street=%s, city=%s, ZipCode=%s]", id, street, city, ZipCode);
}


}