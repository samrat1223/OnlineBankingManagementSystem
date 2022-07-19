package com.obms.services;

import java.util.List;

import com.obms.model.Transaction;

public interface TransactionCrud {
	
		int insertRecord(Transaction transaction);
		int updateRecord(Transaction transaction);
		int deleteRecord(int Transaction_Id);
		List<Transaction> getAllRecords();
		Transaction getTransactionByTransaction_Id(int Transaction_Id);

}
