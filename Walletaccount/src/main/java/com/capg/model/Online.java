package com.capg.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity

@Table(name="user_Master")
public class Online{

	@Id
	private Long accNo;
	private String accHolder;
	private Long phoneno;
	private String email;
	private String password;
	private Double balance;
		
	
public Online () {}

	public Online(Long accNo, String accHolder,  Long phoneno, String email, String password,  Double balance) {
		super();
		this.accNo = accNo;
		this.accHolder = accHolder;
		this.phoneno = phoneno;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}



	public Long getAccNo() {
		return accNo;
	}



	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}



	public String getAccHolder() {
		return accHolder;
	}



	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}



	public Long getPhoneno() {
		return phoneno;
	}



	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
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



	public Double getBalance() {
		return balance;
	}



	public void setBalance(Double balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "Online [successfully inserted]";
	}


	
	

	
	}
