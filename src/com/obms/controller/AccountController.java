package com.obms.controller;

import java.util.List;

import com.obms.model.Account;
import com.obms.services.AccountService;


public class AccountController {

	AccountService accountservice;
	
	public AccountController() {
		accountservice=new AccountService();
	}
	
	
	public int insertRecord(Account account) {
		int result=accountservice.insertRecord(account);
		return result;
	}

	
	public int updateRecord(Account account) {
		int result=accountservice.updateRecord(account);
		return result;
	}

	
	public int deleteRecord(long Accnt_No) {
		int result=accountservice.deleteRecord(Accnt_No);
		return result;
	}

	
	public List<Account> getAllRecords() {
		List <Account> list=accountservice.getAllRecords();
		return list;
	}

	
	public Account getAccountByAccno(long Accnt_No) {
		Account account=accountservice.getAccountByAccno(Accnt_No);
		return account;
	}

}
