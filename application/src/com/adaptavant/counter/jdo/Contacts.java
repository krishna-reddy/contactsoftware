package com.adaptavant.counter.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
/**
 * 
 * @author Krishna.Reddy
 *Annotate the class with @PersistenceCapable to make Contacts as a persistence object.
 */
@PersistenceCapable(detachable="true")
public class Contacts {
	//declare the email as primary key
    @PrimaryKey
    private String email;

    //declare the other properties
    private String firstname,lastname,company,telephone,address;
    
    private int contactMethods;

    //setter and getter methods
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactMethods() {
		return contactMethods;
	}

	public void setContactMethods(int contactMethods) {
		this.contactMethods = contactMethods;
	}
    
    
    
   }