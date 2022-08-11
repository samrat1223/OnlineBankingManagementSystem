package com.obms.services;

import java.util.List;

import com.obms.model.Account;

//Interface providing the crud operation to be performed
public interface AccountCrud {

	int insertRecord(Account account);

	int updateRecord(Account account);

	int deleteRecord(long Accnt_No);

	List<Account> getAllRecords();

	Account getAccountByAccno(long Accnt_No);

}
