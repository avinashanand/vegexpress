package com.experiment.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class UserResponse {
	String userId;
	String email;
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	String mobile;
	Address address;
	
	
	public UserResponse(String userId, String email, String mobile, Address address){
		this.userId = userId;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
	
}
