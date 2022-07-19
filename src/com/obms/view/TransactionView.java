package com.obms.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.obms.controller.TransactionController;
import com.obms.model.Transaction;

public class TransactionView {
	
	public int transactionview() throws Exception
	{
		TransactionController transactionctrl = new TransactionController();
		int result;
		Transaction Transaction = null;
		
		int Transaction_Id;
		int Amount;
		Date Transac_Date;
		String Sender;
		String Receiver;
		String Transac_Type;
		int Accnt_No;
		
		int choice;
		int accno;
		boolean ch=true;
		while(ch){
		System.out.println("1. Add Record");
		System.out.println("2. Update Record");
		System.out.println("3. Delete Record");
		System.out.println("4. View Records");
		System.out.println("5. View a Record");
		System.out.println("0. Exit ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");
		choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Enter Transaction_Id,Amount, Transac_Date, Sender,Receiver,Transac_Type,Accnt_No");
			Transaction_Id = sc.nextInt();
			sc.nextLine();
			Amount=sc.nextInt();
		    sc.nextLine();
			Transac_Date = new SimpleDateFormat("yyyy-MM-dd").parse(sc.nextLine());
			Sender = sc.nextLine();
			Receiver = sc.nextLine();
			Transac_Type = sc.nextLine();
			Accnt_No=sc.nextInt();
			Transaction = new Transaction(Transaction_Id,Amount, Transac_Date, Sender,Receiver,Transac_Type,Accnt_No);
			result = transactionctrl.insertRecord(Transaction);
			if (result > 0)
				System.out.println("Record Inserted");
			else
				System.out.println("Record not inserted");
			break;
		case 2:
			System.out.println("Enter Transaction_Id,Amount, Transac_Date, Sender,Receiver,Transac_Type,Accnt_No");
			Transaction_Id = sc.nextInt();
			sc.nextLine();
			Amount=sc.nextInt();
		    sc.nextLine();
			Transac_Date = new SimpleDateFormat("yyyy-MM-dd").parse(sc.nextLine());
			Sender = sc.nextLine();
			Receiver = sc.nextLine();
			Transac_Type = sc.nextLine();
			Accnt_No=sc.nextInt();
			Transaction = new Transaction(Transaction_Id,Amount, Transac_Date, Sender,Receiver,Transac_Type,Accnt_No);
			
			result = transactionctrl.updateRecord(Transaction);
			if (result > 0)
				System.out.println("Record updated");
			else
				System.out.println("Record not found");
			break;

		case 3:
			System.out.println("Enter transactionid");
		    Transaction_Id = sc.nextInt();
			result = transactionctrl.deleteRecord(Transaction_Id);
			if (result > 0)
				System.out.println("Record deleted");
			else
				System.out.println("Record not found");
			break;
		case 4:
			List<Transaction> list=transactionctrl.getAllRecords();
			if(list.size()==0)
				System.out.println("No record found");
			for(Transaction transac : list){
				System.out.println(transac.getTransaction_Id()+"\t"+transac.getAmount()+"\t"+transac.getTransac_Date()+"\t"+transac.getSender()+"\t"+transac.getReceiver()+"\t"+transac.getTransac_Type()+transac.getAccnt_No());
			}
		break;
		
		case 5:
			System.out.println("Enter Transaction_Id");
			Transaction_Id=sc.nextInt();
			Transaction=transactionctrl.getTransactionByTransaction_Id(Transaction_Id);
			System.out.println("Transaction_Id="+Transaction.getTransaction_Id());
			System.out.println("Amount="+Transaction.getAmount());
			System.out.println("Date="+Transaction.getTransac_Date());
			System.out.println("Sender"+Transaction.getSender());
			System.out.println("Receiver="+Transaction.getReceiver());
			System.out.println("type="+Transaction.getTransac_Type());
			System.out.println("accno="+Transaction.getAccnt_No());
			break;
		case 0: 
			ch=false;
		break;

		}
	}
		return 0;
	}

}
