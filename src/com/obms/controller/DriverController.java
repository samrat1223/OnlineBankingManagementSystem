package com.obms.controller;

import com.obms.services.DriverService;

//Fetching Account details of a customer using his ID
public class DriverController {

	//Invoking the service
	DriverService driverservice = new DriverService();
	
	//Method to return the details
	public int getAccount_Details_By_Cust_ID(int Cust_ID) {
		int result=driverservice.getAccount_Details_By_Cust_ID(Cust_ID);
		return result;
	}
}
