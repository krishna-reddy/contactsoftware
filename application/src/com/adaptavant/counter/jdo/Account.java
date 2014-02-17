package com.adaptavant.counter.jdo;

import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.PrimaryKey;
/**
 * 
 * @author Krishna.Reddy
 *	Annotate the class with @PersistenceCapable to make Account as a persistence object.
 */
@PersistenceCapable(detachable="true")
public class Account {
	private String fname;
	private String lname;
	private String email;
	private String password;
	
	//Declare the primary key for object
	@PrimaryKey
	private String username;
	
	//setter and getter methods
	
	public String getFname() {
		return fname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	
	
	

}
