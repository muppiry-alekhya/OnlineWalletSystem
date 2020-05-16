package com.capg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.model.Online;

import java.util.Optional;
import com.capg.model.Transaction;

import com.capg.exceptions.IdNotFoundException;
@Repository
public  class OnlineDaoImp implements OnlineDao {

	@Autowired
	OnlineRepo brepo;
	@Autowired
	TransactionRepo trepo;

	@Override
	public Online createAccount(Online online) {

		  Transaction tran = new Transaction(); 
		  tran.setBalance(online.getBalance());
		  tran.setCreditedAmount(online.getBalance());
		  tran.setTransactionId((long)(Math.random()*100));
		  tran.setDebitedAmount((double) 0); 
		  tran.setAccNo(online.getAccNo()); 
		 
		  trepo.save(tran);
		  return brepo.save(online);
		 
		
	}

	public void setBrepo(OnlineRepo brepo) {
		this.brepo = brepo;
	}
	
@SuppressWarnings("null")
@Override
public boolean  loginUser(Online u)
{
    Online ud=brepo.findByAccNo(u.getAccNo());
		
		  if(ud!=null)
		  {
		   if((ud.getPassword()).equals(u.getPassword()))
		  { 
			 return true;
		  }
		  }
		   return false;
		  }
	


}
