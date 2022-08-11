package com.obms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.obms.model.Account;
import com.obms.services.AccountService;

// Test class to test account service methods
class AccountTestCase {

	//Invoking the service for account class
	private static AccountService accountservice = new AccountService();

	// Test Case for inserting a record
	@Test
	void testInsertRecord() {
		Account account = new Account();
		account.setAccnt_No(8557);
		account.setAccnt_Type("savings");
		account.setAccnt_Balance(4114);
		account.setIFSC_Code("Odi4517");
		account.setOpening_Date("2016-10-15");
		account.setBranch_Name("Bombay");
		account.setBranch_Code("4412");
		account.setCust_ID(4224);
		account.setCust_NomineeName("Father");

		accountservice.insertRecord(account);
		Account recordFromDb = accountservice.getAccountByAccno(8557);
		assertEquals("savings", recordFromDb.getAccnt_Type(), "Account type must be equals");
	}

	// TestCase for updating a record
	@Test
	void testUpdateRecord() {
		Account account = new Account();
		account.setAccnt_No(8558);
		account.setAccnt_Type("current");
		account.setAccnt_Balance(4004);
		account.setIFSC_Code("Odis4517");
		account.setOpening_Date("2009-11-15");
		account.setBranch_Name("Delhi");
		account.setBranch_Code("4147");
		account.setCust_ID(4995);
		account.setCust_NomineeName("Father");
		accountservice.insertRecord(account);
		account.setAccnt_Balance(40004);
		accountservice.updateRecord(account);

		Account recordFromDb = accountservice.getAccountByAccno(8558);
		assertEquals("current", recordFromDb.getAccnt_Type(), "Updated account type must be equal");
	}

	// TestCase for deleting a record
	@Test
	void testDeleteRecord() {
		accountservice.deleteRecord(8556);
		Account recordFromDb1 = accountservice.getAccountByAccno(8556);
		assertNull(recordFromDb1.getAccnt_No(), "Account should be Null");
	}

	// TestCase for getting all records from the account table

	@Test
	void testGetAllRecords() {

		List<Account> account = accountservice.getAllRecords();
		Assert.assertEquals(6, account.size());
	}

	// TestCase for getting a particular record from account table
	@Test
	void testGetAccountByAccno() {

		Account account = new Account();
		Account recordFromDb = accountservice.getAccountByAccno(5858);
		assertEquals(recordFromDb.getBranch_Name(), "sealdah", "Successfully fetched a single account");

	}
}
