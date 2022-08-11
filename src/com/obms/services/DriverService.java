package com.obms.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.obms.services.AccountConnection;

// Service class to implement join related operations
public class DriverService {

	public int getAccount_Details_By_Cust_ID(int n) {
		int res1 = 0;
		try {
			Connection con = AccountConnection.getConnection();
			Statement stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement(
					"select * from account inner join customer on account.Cust_ID=customer.Cust_ID where customer.Cust_ID=?");
			ps.setInt(1, n);
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				res1 = res.getInt(1);
			}
			return res1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res1;

	}
}
