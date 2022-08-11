package com.obms.services;

import java.sql.Connection;
import java.sql.DriverManager;

//Database Connection to performing operations for Customer
public class CustomerConnection {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingmanagementsystem", "root",
					"password");
		} catch (Exception e) {

			e.printStackTrace();
		}

		return con;

	}

}
