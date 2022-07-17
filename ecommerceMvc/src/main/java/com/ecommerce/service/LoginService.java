package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.AccountDao;
import com.ecommerce.entity.Account;
@Service
public class LoginService {
	
	@Autowired
	private AccountDao accountDao;

	public Account checkLoginAccount(String username, String password) {
		 
		return accountDao.checkLoginAccount(username, password);
	}
}
