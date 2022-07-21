package com.bms.service;

import java.util.List;

import com.bms.model.Account;

public interface AccountCrud {
	int insertRecord(Account account);
	int updateRecord(Account account);
	int deleteRecord(long Accnt_No);
	List<Account> getAllRecords();
	Account getAccountByAccno(long Accnt_No);

}
