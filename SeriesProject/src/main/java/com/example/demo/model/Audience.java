package com.example.demo.model;

//import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;

@Entity
//@Table(name="spectators")

public class Audience 
{
	@Id
	@GeneratedValue
	private int id;
	private String name;
    private String email;
    private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private AudienceAddress address;
	public AudienceAddress getAddress() {
		return address;
	}
	public void setAddress(AudienceAddress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Audience [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + "]";
	}

}
    
  