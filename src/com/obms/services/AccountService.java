package com.obms.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.obms.model.Account;
import com.obms.services.DatabaseConnection;

// Account related operation performed here 
public class AccountService implements AccountCrud {

	// Function to insert a record
	@Override
	public int insertRecord(Account account) {

		int result = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			
			// To insert records
			PreparedStatement ps = con.prepareStatement(
					"insert into account(Accnt_No,Accnt_Type,Accnt_Balance,IFSC_Code,Opening_Date,Branch_Name,Branch_Code,Cust_ID,Cust_NomineeName) values(?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, account.getAccnt_No());
			ps.setString(2, account.getAccnt_Type());
			ps.setLong(3, account.getAccnt_Balance());
			ps.setString(4, account.getIFSC_Code());
			ps.setString(5, account.getOpening_Date());
			ps.setString(6, account.getBranch_Name());
			ps.setString(7, account.getBranch_Code());
			ps.setInt(8, account.getCust_ID());
			ps.setString(9, account.getCust_NomineeName());
			result = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	// Function to update a record
	@Override
	public int updateRecord(Account account) {

		int result = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			 
			// To insert records
			PreparedStatement ps = con.prepareStatement(
					"update account set Accnt_Type=?,Accnt_Balance=?, IFSC_Code=?, Opening_Date=?, Branch_Name=?, Branch_Code=?, Cust_ID =?, Cust_NomineeName=? where Accnt_No=?");

			ps.setString(1, account.getAccnt_Type());
			ps.setLong(2, account.getAccnt_Balance());
			ps.setString(3, account.getIFSC_Code());
			ps.setString(4, account.getOpening_Date());
			ps.setString(5, account.getBranch_Name());
			ps.setString(6, account.getBranch_Code());
			ps.setInt(7, account.getCust_ID());
			ps.setString(8, account.getCust_NomineeName());
			ps.setLong(9, account.getAccnt_No());

			result = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	// Function to delete a record
	@Override
	public int deleteRecord(long Accnt_No) {

		int result = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from account where Accnt_No=?");

			ps.setLong(1, Accnt_No);

			result = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// Function to list all records
	@Override
	public List<Account> getAllRecords() {
		ArrayList<Account> list = new ArrayList<>();
		try {
			Connection con = DatabaseConnection.getConnection();
			// To get all Records
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from account");
			// Add all Records in ArrayList

			while (rs.next()) {

				list.add(new Account(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));

			}
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	// Function to fetch a particular record
	@Override
	public Account getAccountByAccno(long Accnt_No) {
		Account account = null;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from account where Accnt_No=?");
			ps.setLong(1, Accnt_No);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				account = new Account(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

}
