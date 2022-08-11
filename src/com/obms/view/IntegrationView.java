package com.obms.view;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;


public class IntegrationView {
	//private static final Logger logger = LogManager.getLogger(IntegrationView.class);
	final static Logger logger=Logger.getLogger(CustomerView.class.getName());
	
	
	//Function to give the all the choices 
	public static int choices()
	{
		//BasicConfigurator.configure(); 
			
		int n;
		logger.info("select Your choice from below for accessing a tables");
		Scanner sc= new Scanner(System.in);
		logger.info("1. Customer Table");
		logger.info("2. Account Table");
		logger.info("3. Transaction table");
		logger.info("4. Get Account Details from Cust_ID");
		logger.info("0  Exit from here");
		logger.info("Enter Your choice");
		return sc.nextInt();
	}
	
	/*public static int bank()
	{
		BasicConfigurator.configure(); 
		
		int n;
		logger.info("Select role : ");
		Scanner sc = new Scanner(System.in);
		logger.info("1. Admin");
		logger.info("2. User");
		return sc.nextInt();
	}*/
	
	//To set the login username & password
	public static boolean validate(String username,String password)
	{
		if(username.equalsIgnoreCase("user") && password.equalsIgnoreCase("pass"))
		{
			return true;
		}
		else
			return false;
	}
	
	//The main method
	public static void main(String[] args) throws Exception
	{
		
		//BasicConfigurator.configure();  
		
		//logger.setAdditivity(true);
		
		Scanner sc=new Scanner(System.in);
		
		int val;
		int choice;
		logger.info("Enter username");
		String username=sc.nextLine();
		logger.info("Enter password");
		String password=sc.nextLine();
		if(validate(username,password))
		{

			AccountView accntv=new AccountView();
			TransactionView transacv=new TransactionView();
			CustomerView custv=new CustomerView();
			DriverView driverv=new DriverView();
			
		boolean x=true;
		while(x){
			choice=choices();
			switch (choice) {
			case 1:
				custv.customerview();
				break;
			case 2:
				accntv.accountview();
				break;
			case 3:
				transacv.transactionview();
				break;
			case 4:
				driverv.driverview();
				break;
			case 0:
				x=false;
				break;
		}
	}
		}
	}
}


	
	


