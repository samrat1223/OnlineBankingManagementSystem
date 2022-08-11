package com.obms.services;

import java.sql.Connection;
import java.sql.DriverManager;

//Database Connectivity for the related operation
public class DatabaseConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingmanagementsystem","root","Differentiation@1124");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}


}
