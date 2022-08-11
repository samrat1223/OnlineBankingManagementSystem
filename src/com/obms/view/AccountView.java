package com.obms.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;



import com.obms.controller.AccountController;
import com.obms.model.Account;

public class AccountView {
	
	 //private static final Logger logger = LogManager.getLogger(AccountView.class);
	final static Logger logger=Logger.getLogger(AccountView.class.getName());
	 
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
		logger.info("1. Add Record");
		//logger.setAdditivity(false);
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
			logger.info("Enter Accnt_No,Accnt_Type,Accnt_Balance,IFSC_Code,Opening_Date,Branch_Name,Branch_Code,Cust_ID,Cust_NomineeName");
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
				logger.info("Record Inserted");
			else
				logger.info("Record not inserted");
			break;
			
		case 2:
			logger.info("Enter Accnt_No,Accnt_Type,Accnt_Balance,IFSC_Code,Opening_Date,Branch_Name,Branch_Code,Cust_NomineeName,Cust_ID");
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
				logger.info("Record updated");
			else
				logger.info("Record not found");
			break;
			
		case 3:
			logger.info("Enter accno");
			Accnt_No = sc.nextLong();
			result = accountctrl.deleteRecord(Accnt_No);
			if (result > 0)
				logger.info("Record deleted");
			else
				logger.info("Record not found");
			break;
			
		case 4:
			List<Account> list=accountctrl.getAllRecords();
			if(list.size()==0)
			{
				logger.info("No records found");
			}
			else
			{
			for(Account acc : list){
				logger.info(acc.getAccnt_No()+"\t"+acc.getAccnt_Type()+" "+acc.getAccnt_Balance()+" "+acc.getIFSC_Code()+" "+
						acc.getOpening_Date()+" "+acc.getBranch_Name()+" "+acc.getBranch_Code()+" "+acc.getCust_ID()+""+acc.getCust_NomineeName());
			}
			}
			break;
		
		case 5:
			logger.info("Enter accno");
			Accnt_No=sc.nextLong();
			account=accountctrl.getAccountByAccno(Accnt_No);
			logger.info("Account_No = "+account.getAccnt_No());
			logger.info("Account_type = "+account.getAccnt_Type());
			logger.info("Accnt_Balance = "+account.getAccnt_Balance());
			logger.info("IFSC_Code = "+account.getIFSC_Code());
			logger.info("Opening_Date = "+account.getOpening_Date());
			logger.info("Branch_Name = "+account.getBranch_Name());
			logger.info("Branch_Code = "+account.getBranch_Code());
			logger.info("Cust_id "+account.getCust_ID());
			logger.info("Cust_NomineeName"+account.getCust_NomineeName());
			break;
		
		case 0: ch=false;
		break;
		}
		}
		return 0;
	}

}
