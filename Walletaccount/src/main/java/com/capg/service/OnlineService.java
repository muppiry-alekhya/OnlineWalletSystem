package com.capg.service;

import java.util.List;
import java.util.Optional;


import com.capg.model.Online;
import com.capg.model.Transaction;



public interface OnlineService {

	public abstract Online createAccount(Online online);

		public abstract boolean loginUser(Online u);
	

	

}
