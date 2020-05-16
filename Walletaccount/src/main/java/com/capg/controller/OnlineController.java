package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Online;
import com.capg.model.Transaction;

import com.capg.service.OnlineService;

import com.capg.exceptions.IdNotFoundException;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OnlineController {

	@Autowired
	private OnlineService service;
	
	

	/*
	 *This method helps the users to register an account using HTTP post*
	 */
	
	
	
	@PostMapping(path="/create")
	public ResponseEntity<String> createAccount(@RequestBody Online online)
	{
		Online e = service.createAccount(online);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else
		{
			return new ResponseEntity<>("User created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
		
	
	
	/*
	 * This methods allows the user to login to their account  using HTTP put
	 */
	
	
	
	@PutMapping("/Loginuser")
	public ResponseEntity<String> loginUser(@RequestBody Online u)
	{
		
		 boolean flag=service.loginUser(u);
		if(flag==false)
		{
			throw new IdNotFoundException("User not found");
		}
		else 
		{
			return new ResponseEntity<>("Login successful", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
}