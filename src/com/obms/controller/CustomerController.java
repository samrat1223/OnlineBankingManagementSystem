package com.obms.controller;

import java.util.List;


import com.obms.model.Customer;
import com.obms.services.CustomerService;

//Customer Controller is responsible for all the crud operations performing
public class CustomerController {
	
	//Invoking customerservice class and making an object to perform operations
	CustomerService customerservice;

    public CustomerController() {
    	customerservice=new CustomerService();
    }
    
    //Method to insert a record

	public int insertRecord(Customer customer) {
		int result=customerservice.insertRecord(customer);
		return result;
	}

	//Method to update a record
	public int updateRecord(Customer customer) {
		int result=customerservice.updateRecord(customer);
		return result;
	}

	//Method to delete a record
	public int deleteRecord(int Cust_ID) {
		int result=customerservice.deleteRecord(Cust_ID);
		return result;
	}

	//Method to return all the customers
	public List<Customer> getAllRecords() {
		List <Customer> list=customerservice.getAllRecords();
		return list;
	}

	//Method to return a single customer using his Id
	public Customer getCustomerByCust_ID(int Cust_ID) {
		Customer customer=customerservice.getCustomerByCust_ID(Cust_ID);
		return customer;
	}

}
