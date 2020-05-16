package com.capg;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.capg.dao.*;
import com.capg.model.Transaction;
import com.capg.service.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OnlineWalletApplicationTests {
	@Mock
	OnlineDaoImp onlinedao; 
	
	@InjectMocks
	OnlineServiceImp service;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testcreateAccount()
	{
		Transaction tran=new Transaction();
	}

}
