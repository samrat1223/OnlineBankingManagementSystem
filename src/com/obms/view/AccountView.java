package com.obms.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.obms.controller.AccountController;
import com.obms.model.Account;

public class AccountView {
	
	public int accountview() throws Exception {
		AccountController accountctrl = new AccountController();
		int result;
		Account account= new Account();
		
		long Accnt_No;
		String Accnt_Type;
		long Accnt_Balance;
		String IFSC_Code;
		String Opening_Date;
	    String Branch_Name;
		String Branch_Code;
		int Cust_ID;
		String Cust_NomineeName;
		
		int choice;
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
			System.out.println("Enter Accnt_No,Accnt_Type,Accnt_Balance,IFSC_Code,Opening_Date,Branch_Name,Branch_Code,Cust_ID,Cust_NomineeName");
			Accnt_No = sc.nextLong();
			sc.nextLine();
			Accnt_Type = sc.next();
			sc.nextLine();
			Accnt_Balance = sc.nextLong();
			sc.nextLine();
			IFSC_Code=sc.next();
			sc.nextLine();
			Opening_Date = sc.next(); //new SimpleDateFormat("yyyy-MM-dd").parse(sc.next());
			sc.nextLine();
			Branch_Name = sc.next();
			sc.nextLine();
			Branch_Code= sc.next();
			sc.nextLine();
			Cust_ID=sc.nextInt();
			sc.nextLine();
			Cust_NomineeName=sc.next();
			

			account = new Account(Accnt_No,Accnt_Type,Accnt_Balance,IFSC_Code,Opening_Date,Branch_Name,Branch_Code,Cust_ID,Cust_NomineeName);
			result = accountctrl.insertRecord(account);
			if (result > 0)
				System.out.println("Record Inserted");
			else
				System.out.println("Record not inserted");
			break;
			
		case 2:
			System.out.println("Enter Accnt_No,Accnt_Type,Accnt_Balance,IFSC_Code,Opening_Date,Branch_Name,Branch_Code,Cust_NomineeName,Cust_ID");
			Accnt_No = sc.nextLong();
			sc.nextLine();
			Accnt_Type = sc.next();
			Accnt_Balance = sc.nextLong();
			sc.nextLine();
			IFSC_Code=sc.next();
			sc.nextLine();
			Opening_Date = sc.next();//new SimpleDateFormat("yyyy-MM-dd").parse(sc.next());
			sc.nextLine();
			Branch_Name = sc.next();
			sc.nextLine();
			Branch_Code= sc.next();
			sc.nextLine();
			Cust_NomineeName=sc.next();
			sc.nextLine();
			Cust_ID=sc.nextInt();

			

			account = new Account(Accnt_No,Accnt_Type,Accnt_Balance,IFSC_Code,Opening_Date,Branch_Name,Branch_Code,Cust_ID,Cust_NomineeName);
			result = accountctrl.updateRecord(account);
			if (result > 0)
				System.out.println("Record updated");
			else
				System.out.println("Record not found");
			break;
			
		case 3:
			System.out.println("Enter accno");
			Accnt_No = sc.nextLong();
			result = accountctrl.deleteRecord(Accnt_No);
			if (result > 0)
				System.out.println("Record deleted");
			else
				System.out.println("Record not found");
			break;
			
		case 4:
			List<Account> list=accountctrl.getAllRecords();
			if(list.size()==0)
			{
				System.out.println("No records found");
			}
			else
			{
			for(Account acc : list){
				System.out.println(acc.getAccnt_No()+"\t"+acc.getAccnt_Type()+" "+acc.getAccnt_Balance()+" "+acc.getIFSC_Code()+" "+
						acc.getOpening_Date()+" "+acc.getBranch_Name()+" "+acc.getBranch_Code()+" "+acc.getCust_ID()+""+acc.getCust_NomineeName());
			}
			}
			break;
		
		case 5:
			System.out.println("Enter accno");
			Accnt_No=sc.nextLong();
			account=accountctrl.getAccountByAccno(Accnt_No);
			System.out.println("Account_No = "+account.getAccnt_No());
			System.out.println("Account_type = "+account.getAccnt_Type());
			System.out.println("Accnt_Balance = "+account.getAccnt_Balance());
			System.out.println("IFSC_Code = "+account.getIFSC_Code());
			System.out.println("Opening_Date = "+account.getOpening_Date());
			System.out.println("Branch_Name = "+account.getBranch_Name());
			System.out.println("Branch_Code = "+account.getBranch_Code());
			System.out.println("Cust_id "+account.getCust_ID());
			System.out.println("Cust_NomineeName"+account.getCust_NomineeName());
			break;
		
		case 0: ch=false;
		break;
		}
		}
		return 0;
	}

}
