package com.obms.controller;

import java.util.List;

import com.obms.model.Transaction;
import com.obms.services.TransactionService;

public class TransactionController {
	
	TransactionService transactionservice;
	public TransactionController()
	{
		transactionservice=new TransactionService();
	}
	

	public int insertRecord(Transaction transaction) {
		int result=transactionservice.insertRecord(transaction);
		return result;
	}


	public int updateRecord(Transaction transaction) {
		
		int result=transactionservice.updateRecord(transaction);
		return result;
	}


	public int deleteRecord(int Transaction_Id) {
		
		int result=transactionservice.deleteRecord(Transaction_Id);
		return result;
	}


	public List<Transaction> getAllRecords() {
		List<Transaction> list=transactionservice.getAllRecords();
		return list;
	}


	public Transaction getTransactionByTransaction_Id(int Transaction_Id) {
		
		Transaction transaction =transactionservice.getTransactionByTransaction_Id(Transaction_Id);
		return transaction;
	}
	

}
