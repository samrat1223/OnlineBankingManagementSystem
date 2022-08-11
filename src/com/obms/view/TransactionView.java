package com.obms.view;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.obms.controller.TransactionController;
import com.obms.model.Transaction;

public class TransactionView {

	final static Logger logger=Logger.getLogger(CustomerView.class.getName());
	
	

	public int transactionview() throws Exception {

		//BasicConfigurator.configure();
		
		//BasicConfigurator.resetConfiguration();
		//logger.setAdditivity(true);

		TransactionController transactionctrl = new TransactionController();
		int result;
		Transaction Transaction = null;
		

		int Transaction_Id;
		int Amount;
		String Transac_Date;
		String Sender;
		String Receiver;
		String Transac_Type;
		int Accnt_No;

		int choice;
		int accno;
		boolean ch = true;
		while (ch) {
			logger.info("1. Add Record");
			logger.info("2. Update Record");
			logger.info("3. Delete Record");
			logger.info("4. View Records");
			logger.info("5. View a Record");
			logger.info("0. Exit ");
			Scanner sc = new Scanner(System.in);
			logger.info("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				logger.info("Enter Transaction_Id,Amount, Transac_Date, Sender,Receiver,Transac_Type,Accnt_No");
				Transaction_Id = sc.nextInt();
				sc.nextLine();
				Amount = sc.nextInt();
				sc.nextLine();
				Transac_Date = sc.nextLine();
				Sender = sc.nextLine();
				Receiver = sc.nextLine();
				Transac_Type = sc.nextLine();
				Accnt_No = sc.nextInt();
				Transaction = new Transaction(Transaction_Id, Amount, Transac_Date, Sender, Receiver, Transac_Type,
						Accnt_No);
				result = transactionctrl.insertRecord(Transaction);
				if (result > 0)
					logger.info("Record Inserted");
				else
					logger.info("Record not inserted");
				break;
			case 2:
				logger.info("Enter Transaction_Id,Amount, Transac_Date, Sender,Receiver,Transac_Type,Accnt_No");
				Transaction_Id = sc.nextInt();
				sc.nextLine();
				Amount = sc.nextInt();
				sc.nextLine();
				Transac_Date = sc.nextLine();
				Sender = sc.nextLine();
				Receiver = sc.nextLine();
				Transac_Type = sc.nextLine();
				Accnt_No = sc.nextInt();
				Transaction = new Transaction(Transaction_Id, Amount, Transac_Date, Sender, Receiver, Transac_Type,
						Accnt_No);

				result = transactionctrl.updateRecord(Transaction);
				if (result > 0)
					logger.info("Record updated");
				else
					logger.info("Record not found");
				break;

			case 3:
				logger.info("Enter transactionid");
				Transaction_Id = sc.nextInt();
				result = transactionctrl.deleteRecord(Transaction_Id);
				if (result > 0)
					logger.info("Record deleted");
				else
					logger.info("Record not found");
				break;
			case 4:
				List<Transaction> list = transactionctrl.getAllRecords();
				if (list.size() == 0)
					logger.info("No record found");
				for (Transaction transac : list) {
					logger.info(transac.getTransaction_Id() + "\t" + transac.getAmount() + "\t"
							+ transac.getTransac_Date() + "\t" + transac.getSender() + "\t" + transac.getReceiver()
							+ "\t" + transac.getTransac_Type() + transac.getAccnt_No());
				}
				break;

				
			case 5:
				logger.info("Enter Transaction_Id");
				Transaction_Id = sc.nextInt();
				Transaction = transactionctrl.getTransactionByTransaction_Id(Transaction_Id);
				logger.info("Transaction_Id=" + Transaction.getTransaction_Id());
				logger.info("Amount=" + Transaction.getAmount());
				logger.info("Date=" + Transaction.getTransac_Date());
				logger.info("Sender" + Transaction.getSender());
				logger.info("Receiver=" + Transaction.getReceiver());
				logger.info("type=" + Transaction.getTransac_Type());
				logger.info("accno=" + Transaction.getAccnt_No());
				break;
			case 0:
				ch = false;
				break;

			}
		}
		return 0;
	}

}
