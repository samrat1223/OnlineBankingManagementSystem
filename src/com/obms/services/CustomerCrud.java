package com.obms.services;

import java.util.List;

import com.obms.model.Customer;

//Interface providing crud operations to perform
public interface CustomerCrud {

	int insertRecord(Customer customer);

	int updateRecord(Customer customer);

	int deleteRecord(int Cust_ID);

	List<Customer> getAllRecords();

	Customer getCustomerByCust_ID(int Cust_ID);

}
