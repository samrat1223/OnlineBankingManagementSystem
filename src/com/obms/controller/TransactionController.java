package com.obms.controller;

import java.util.List;

import com.obms.model.Transaction;
import com.obms.services.TransactionService;

//Controller to perform Crud operation in Transaction table
public class TransactionController {
	
	//Invoking the service and making object
	TransactionService transactionservice;
	public TransactionController()
	{
		transactionservice=new TransactionService();
	}
	
    //Method to insert a record
	public int insertRecord(Transaction transaction) {
		int result=transactionservice.insertRecord(transaction);
		return result;
	}

	//Method to update a record
	public int updateRecord(Transaction transaction) {
		
		int result=transactionservice.updateRecord(transaction);
		return result;
	}


	//Method to delete a record
	public int deleteRecord(int Transaction_Id) {
		
		int result=transactionservice.deleteRecord(Transaction_Id);
		return result;
	}


	//Method to get all the records
	public List<Transaction> getAllRecords() {
		List<Transaction> list=transactionservice.getAllRecords();
		return list;
	}


	//Method to return a particular recrod using TransactionID
	public Transaction getTransactionByTransaction_Id(int Transaction_Id) {
		
		Transaction transaction =transactionservice.getTransactionByTransaction_Id(Transaction_Id);
		return transaction;
	}
	

}
