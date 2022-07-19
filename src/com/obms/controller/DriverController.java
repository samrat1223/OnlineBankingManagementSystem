package com.obms.controller;

import com.obms.services.DriverService;

public class DriverController {

	DriverService driverservice = new DriverService();
	
	public int getAccount_Details_By_Cust_ID(int Cust_ID) {
		int result=driverservice.getAccount_Details_By_Cust_ID(Cust_ID);
		return result;
	}
}
