package com.obms.controller;

import java.util.List;

import com.obms.model.Account;
import com.obms.services.AccountService;

// Account Controller is reponsible for all the crud operations performing
public class AccountController {

	AccountService accountservice;
	
	//Invoking the Account Service
	public AccountController() {
		accountservice=new AccountService();
	}
	
	// Method to insert a record
	public int insertRecord(Account account) {
		int result=accountservice.insertRecord(account);
		return result;
	}

	// Method to update a record
	public int updateRecord(Account account) {
		int result=accountservice.updateRecord(account);
		return result;
	}

	// Method to delete a record
	public int deleteRecord(long Accnt_No) {
		int result=accountservice.deleteRecord(Accnt_No);
		return result;
	}

	// Method to View all records
	public List<Account> getAllRecords() {
		List <Account> list=accountservice.getAllRecords();
		return list;
	}

	//Method to view a particular Record
	public Account getAccountByAccno(long Accnt_No) {
		Account account=accountservice.getAccountByAccno(Accnt_No);
		return account;
	}

}
