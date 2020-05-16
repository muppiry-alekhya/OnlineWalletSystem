package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.OnlineDao;
import com.capg.model.Online;
import com.capg.model.Transaction;
import com.capg.dao.OnlineDaoImp;
import com.capg.dao.OnlineRepo;
import com.capg.exceptions.IdNotFoundException;

@Service
public  class OnlineServiceImp implements OnlineService{
	@Autowired
	OnlineRepo brepo;

	@Autowired
	private OnlineDao dao;
	
	@Override
	public Online createAccount(Online online
			) {
		
		return dao.createAccount(online);
	}
	

	
	@Override
	public boolean loginUser(Online u) 
	
	{
		
		return dao.loginUser(u);        
	}

	
}
