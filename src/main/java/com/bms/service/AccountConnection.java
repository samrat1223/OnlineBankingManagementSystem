package com.bms.service;

import java.sql.Connection;

import java.sql.DriverManager;

public class AccountConnection {
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			System.out.println("Start");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Check connection");
			
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingmanagementsystem","root","ROOt123@");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}


}
