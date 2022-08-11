package com.obms.view;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import java.util.Scanner;
import java.util.logging.Logger;

import com.obms.controller.DriverController;

public class DriverView {
	//private static final Logger logger = LogManager.getLogger(DriverView.class);
	final static Logger logger=Logger.getLogger(DriverView.class.getName());
	
	//To show the Driver related crud operations performed
      public int driverview() throws Exception{
    	  
    	 // BasicConfigurator.configure();
    	  
    	  DriverController driverctrl = new DriverController();
    	  int result;
    	  while(true) {
    		  logger.info("1. Enter Cust_ID to get account details");
    		  logger.info("0. exit from the program");
    		  Scanner sc = new Scanner(System.in);
    		  int choice = sc.nextInt();
    		  switch(choice) {
    		  case 1 :
    			  logger.info("Enter Cust_ID");
    			  int Cust_ID = sc.nextInt();
    			  result = driverctrl.getAccount_Details_By_Cust_ID(Cust_ID);
    			 
    			  if(result == 0)
    				  logger.info("There is no record found");
  				  else
  					logger.info("Your Account Number is="+driverctrl.getAccount_Details_By_Cust_ID(Cust_ID));
    			 // System.out.println("Your Account Number is="+driverctrl.getAccount_Details_By_Cust_ID(Accnt_No));
  				break;
    		  case 0:
    			  logger.info("Byee to all");
  				  System.exit(0);
  				  break;
    		  }
    	  }
      }
}
