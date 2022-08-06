package com.ecommerce.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.AccountDao;
import com.ecommerce.model.Account;

@Service
public class AccountService {

	@Autowired
	AccountDao accountDao;

	public Account checkLoginAccount(String username, String password) {
		return accountDao.checkLoginAccount(username, password);
	}

	

	public boolean checkUsernameExists(String username) {
		
		return accountDao.checkUsernameExists(username);
	}



	public void createAccount(String username, String password, InputStream inputStream) {
		accountDao.createAccount(username, password, inputStream);
		
	}



	public void editProfileInformation(int accountId, String firstName, String lastName, String address, String email,
			String phone, InputStream inputStream) {
		// TODO Auto-generated method stub
		
	}



	public void updateProfileInformation(int accountId, String firstName, String lastName, String address, String email,
			String phone) {
		accountDao.updateProfileInformation(accountId, firstName, lastName, address, email, phone);
		
	}

}
