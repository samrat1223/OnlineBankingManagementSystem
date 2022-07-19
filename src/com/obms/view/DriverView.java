package com.obms.view;

import java.util.Scanner;

import com.obms.controller.DriverController;

public class DriverView {
      public int driverview() throws Exception{
    	  DriverController driverctrl = new DriverController();
    	  int result;
    	  while(true) {
    		  System.out.println("1. Enter Cust_ID to get account details");
    		  System.out.println("0. exit from the program");
    		  Scanner sc = new Scanner(System.in);
    		  int choice = sc.nextInt();
    		  switch(choice) {
    		  case 1 :
    			  System.out.println("Enter Cust_ID");
    			  int Cust_ID = sc.nextInt();
    			  result = driverctrl.getAccount_Details_By_Cust_ID(Cust_ID);
    			 
    			  if(result == 0)
  					System.out.println("There is no record found");
  				  else
  				     System.out.println("Your loan id is="+driverctrl.getAccount_Details_By_Cust_ID(Cust_ID));
  				break;
    		  case 0:
    			  System.out.println("Byee to all");
  				  System.exit(0);
  				  break;
    		  }
    	  }
      }
}
