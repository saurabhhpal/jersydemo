package com.example.dao;

public class Token {
	
	String token;
	Integer phone;
	String pass;
	
	
	public Token() {
		super();
	}


	public Token(String token, Integer phone,String pass) {
		super();
		
		this.token = token;
		this.phone = phone;
		this.pass=pass;
	}
	
	
	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	
	
	
}
