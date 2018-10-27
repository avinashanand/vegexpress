package com.experiment.model;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class User {
	String userId;
	@Id
	String email;
	String mobile;
	Address address;
	String password;
	Date lastLogin;
	int failedLogin;
	boolean accountlocked;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public int getFailedLogin() {
		return failedLogin;
	}
	public void setFailedLogin(int failedLogin) {
		this.failedLogin = failedLogin;
	}
	public boolean isAccountlocked() {
		return accountlocked;
	}
	public void setAccountlocked(boolean accountlocked) {
		this.accountlocked = accountlocked;
	}
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
	
	
}
