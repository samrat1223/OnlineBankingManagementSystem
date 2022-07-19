package com.obms.view;

import java.util.ArrayList;
import java.util.Scanner;


public class IntegrationView {
	
	public static int choices()
	{
			
		int n;
		System.out.println("select Your choice from below for accessing a tables");
		Scanner sc= new Scanner(System.in);
		System.out.println("1. Customer Table");
		System.out.println("2. Account Table");
		System.out.println("3. Transaction table");
		System.out.println("4. Get Account Details from Cust_ID");
		System.out.println("0  Exit from here");
		System.out.println("Enter Your choice");
		return sc.nextInt();
	}
	
	public static int bank()
	{
		int n;
		System.out.println("Select role : ");
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Admin");
		System.out.println("2. User");
		return sc.nextInt();
	}
	
	public static boolean validate(String username,String password)
	{
		if(username.equalsIgnoreCase("user") && password.equalsIgnoreCase("pass"))
		{
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] args) throws Exception
	{
		
		
		Scanner sc=new Scanner(System.in);
		
		int val;
		int choice;
		System.out.println("Enter username");
		String username=sc.nextLine();
		System.out.println("Enter password");
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


	
	


