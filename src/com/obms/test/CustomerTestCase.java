package com.obms.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.obms.model.Account;
import com.obms.model.Customer;
import com.obms.services.AccountService;
import com.obms.services.CustomerService;
import java.util.*;

// Test Class for testing methods of Customer Service class
class CustomerTestCase {

	//Invoking customerservice
	private static CustomerService customerservice = new CustomerService();
	
	// Test Case for inserting a record
	@Test
	void testInsertRecord() {
		Customer customer = new Customer();
		customer.setCust_ID(4995);
		customer.setCust_Address("khardah");
		customer.setCust_Name("Bikas Das");
		customer.setCust_Password("bik123");
		customer.setCust_Aadharno("151511");
		customer.setCust_Panno("DOVGt544");
		customer.setCust_Email("bik@mail.com");
		customer.setCust_MobileNo(45447774);
		customer.setCust_PinCode(454544);
		customer.setCust_State("Punjab");
		customer.setUser_Name("bik123");
		customer.setCust_NomineeName("mothername");
		customer.setCust_DOB("2000-05-02");
		customer.setAccnt_No(8558);
		
		customerservice.insertRecord(customer);
		Customer recordFromDb = customerservice.getCustomerByCust_ID(4995);
		assertEquals("Punjab", recordFromDb.getCust_State(), "State names must be equals");
	}

	// Test Case for updating a record
	@Test
	void testUpdateRecord() {
		Customer customer = new Customer();
		customer.setCust_ID(4998);
		customer.setCust_Address("Kalighat");
		customer.setCust_Name("Poonam Patra");
		customer.setCust_Password("nam123");
		customer.setCust_Aadharno("114511");
		customer.setCust_Panno("DLKGt514");
		customer.setCust_Email("nam@mail.com");
		customer.setCust_MobileNo(15154544);
		customer.setCust_PinCode(544781);
		customer.setCust_State("Haryana");
		customer.setUser_Name("nam123");
		customer.setCust_NomineeName("fahername");
		customer.setCust_DOB("1997-05-02");
		customer.setAccnt_No(21544);
		customerservice.insertRecord(customer);
		customer.setCust_State("Telengana");
		customerservice.updateRecord(customer);
		
		Customer recordFromDb = customerservice.getCustomerByCust_ID(4998);
		assertEquals("Telengana", recordFromDb.getCust_State(), "Updated customer state must be equal");
		
	}

	
	// Test Case for deleting a record
	/*@Test
	void testDeleteRecord() {
		customerservice.deleteRecord(4998);
		Customer recordFromDb = customerservice.getCustomerByCust_ID(4998);
		assertEquals("null",recordFromDb.getCust_ID(), "Customer should be Null");
	}*/

	// Test Case for fetching all the records
	@Test
	void testGetAllRecords() {
		List<Customer> customer = customerservice.getAllRecords();
		Assert.assertEquals(6, customer.size());
	}

	// Test Case for fetching a particular record
	@Test
	void testGetCustomerByCust_ID() {
		Customer customer = new Customer();
		Customer recordFromDb = customerservice.getCustomerByCust_ID(452104);
		assertEquals("Patna",recordFromDb.getCust_State() ,"Successfully fetched a single account");
	}

}
