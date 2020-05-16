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
import com.capg.exceptions.AmountLessThanZeroException;
import com.capg.exceptions.IdNotFoundException;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OnlineController {

	@Autowired
	private OnlineService service;
	
	
	/*
	 * This methods displays the user balance using HTTP get
	 */
	
	@GetMapping(path="/show/{id}")
	
	public ResponseEntity<Online> showBalance(@PathVariable("id") Long id) {
		Online balance = service.showBalance(id);
		if (balance==null)
		{
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else
		{
			return new ResponseEntity<>(balance, new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	/*
	 * This methods allows the user to add amount in the wallet  using HTTP get
	 */
	
	
	@GetMapping(path="/deposite/{accNo}&{depositeAmount}")
	public Online deposite(@PathVariable Long accNo,@PathVariable Double depositeAmount)
	{

		if(depositeAmount==null||depositeAmount==0)
		{
			throw new AmountLessThanZeroException("Amount cannot be less than zero");	
		}
		return service.deposite(accNo, depositeAmount);
	}
	
	
	/*
	 * This methods allows to view the user details using HTTP get
	 */
	
	
	@GetMapping(path="/get/{accNo}")
	public Online getAccount(@PathVariable Long accNo) 
	
	{
		return service.getAccount(accNo);
	}
	
	
	
	/*
	 * This methods allows the user to withdraw amount from his wallet using HTTP get
	 */
	
	
	@GetMapping(path="/withdraw/{accNo}&{withdrawAmount}")
	public Online withdraw(@PathVariable Long accNo,@PathVariable Double withdrawAmount)
	
	{
		return service.withdraw(accNo,withdrawAmount);
	}
	
	
	/*
	 * This method displays the transaction details using HTTP get
	 */
	
	
	  @GetMapping(path="/print/{accNo}") public List<Transaction>
	  printTransactions(@PathVariable Long accNo) 
	  
	  { 
		  
	 return service.printTransactions(accNo);
		 
	  }
	 

	  /*
		 * This methods allows the user to transfer amount to other account  using HTTP get
		 */
	  
	  
	
	@GetMapping(path="/fund/{saccNo}&{raccNo}&{transferAmount}")
	public Online fundTranfer(@PathVariable Long saccNo,@PathVariable Long raccNo,@PathVariable Double transferAmount)
	
	{
		
		if(transferAmount==null||transferAmount==0)
		{
			throw new AmountLessThanZeroException("Amount cannot be less than zero");	
		}
		
			return service.fundTransfer(saccNo,raccNo, transferAmount);
		

}
}


