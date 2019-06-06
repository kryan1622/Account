package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Account {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=5)
	private int accountnumber;
	@Column(length=50)
	private String firstname;
	@Column(length=50)
	private String lastname;
	
	
	public Account() {
	
	}

	public int getID() {
		return id;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastnane() {
		return lastname;
	}

	public void setLastnane(String lastnane) {
		this.lastname = lastnane;
	}

    public Account(String firstname, String lastname) {
    	this.firstname=firstname;
    	this.lastname=lastname;
    	this.accountnumber=this.id;
    }
	}


