package com.obms.controller;

import java.util.List;


import com.obms.model.Customer;
import com.obms.services.CustomerService;


public class CustomerController {
	
	CustomerService customerservice;

    public CustomerController() {
    	customerservice=new CustomerService();
    }
    

	public int insertRecord(Customer customer) {
		int result=customerservice.insertRecord(customer);
		return result;
	}

	
	public int updateRecord(Customer customer) {
		int result=customerservice.updateRecord(customer);
		return result;
	}

	
	public int deleteRecord(int Cust_ID) {
		int result=customerservice.deleteRecord(Cust_ID);
		return result;
	}

	
	public List<Customer> getAllRecords() {
		List <Customer> list=customerservice.getAllRecords();
		return list;
	}

	
	public Customer getCustomerByCust_ID(int Cust_ID) {
		Customer customer=customerservice.getCustomerByCust_ID(Cust_ID);
		return customer;
	}

}
