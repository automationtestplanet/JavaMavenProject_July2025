package com.automation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Credentials {

	@JsonIgnoreProperties
	private String userName;
	
	@JsonIgnoreProperties
	private String password;
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
}
