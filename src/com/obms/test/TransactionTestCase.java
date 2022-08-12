package com.obms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.obms.model.Customer;
import com.obms.model.Transaction;
import com.obms.services.CustomerService;
import com.obms.services.TransactionService;

//Test Class for testing methods of Transaction Service class
class TransactionTestCase {

	//Invoking transactionservice
	private static TransactionService transactionservice = new TransactionService();
	
	// Test Case insert a record
	@Test
	void testInsertRecord() {
		Transaction transaction = new Transaction();
		transaction.setTransaction_Id(45554);
		transaction.setAmount(4555); 
		transaction.setTransac_Date("2000-10-15");
		transaction.setSender("roni");
		transaction.setReceiver("rani");
		transaction.setTransac_Type("cheque");
		transaction.setAccnt_No(45531);
		
		transactionservice.insertRecord(transaction);
		Transaction recordFromDb = transactionservice.getTransactionByTransaction_Id(45554);
		assertEquals("rani", recordFromDb.getReceiver(), "Receiver must be equals");
		
	}

	
	// Test Case for updating a record
	@Test
	void testUpdateRecord() {
		Transaction transaction = new Transaction();
		transaction.setTransaction_Id(47524);
		transaction.setAmount(4015); 
		transaction.setTransac_Date("2008-12-15");
		transaction.setSender("ronita");
		transaction.setReceiver("rashi");
		transaction.setTransac_Type("cash");
		transaction.setAccnt_No(12445);
		transactionservice.insertRecord(transaction);
		transaction.setSender("Rabi");
		transactionservice.updateRecord(transaction);
		
		Transaction recordFromDb = transactionservice.getTransactionByTransaction_Id(47524);
		assertEquals("Rabi", recordFromDb.getSender(), "Updated money sender state must be equal");
	}

	// Test Case for deleting a record
	@Test
	void testDeleteRecord() {
		transactionservice.deleteRecord(47524);
		Transaction recordFromDb = transactionservice.getTransactionByTransaction_Id(47524);
		assertNull(recordFromDb, "Customer should be Null");
	}
	

	// Test Case for fetching all the records
	@Test
	void testGetAllRecords() {
		List<Transaction> transaction = transactionservice.getAllRecords();
		Assert.assertEquals(3, transaction.size());
	}

	// Test Case for fetching a particular record
	@Test
	void testGetTransactionByTransaction_Id() {
		Transaction transaction = new Transaction();
		Transaction recordFromDb = transactionservice.getTransactionByTransaction_Id(47524);
		assertEquals("Rabi",recordFromDb.getSender() ,"Successfully fetched a single account");
	}

}
