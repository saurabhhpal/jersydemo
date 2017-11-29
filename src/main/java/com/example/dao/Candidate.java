package com.example.dao;

public class Candidate {
	
	
	String name ;
	String pass;
	Integer phone;
	String city;
	String email;
	
	public Candidate()
	{
		
	}		
	public Candidate(String name, String pass, Integer phone, String city, String email) {
		super();
		this.name = name;
		this.pass = pass;
		this.phone = phone;
		this.city = city;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
