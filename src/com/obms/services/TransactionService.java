package com.obms.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.obms.model.Transaction;
import com.obms.services.DatabaseConnection;

//Service class to provide implementation about the crud operation
public class TransactionService implements TransactionCrud {

	// Function to insert a record
	@Override
	public int insertRecord(Transaction transaction) {
		int result = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			// java.sql.Date transac_date=new
			// java.sql.Date(transaction.getTransac_Date().getTime());

			// To insert records
			PreparedStatement ps = con.prepareStatement(
					"insert into transaction(Transaction_Id,Amount,Transac_Date,Sender,Receiver,Transac_Type,Accnt_No) values(?,?,?,?,?,?,?)");
			ps.setInt(1, transaction.getTransaction_Id());
			ps.setInt(2, transaction.getAmount());
			ps.setString(3, transaction.getTransac_Date());
			ps.setString(4, transaction.getSender());
			ps.setString(5, transaction.getReceiver());
			ps.setString(6, transaction.getTransac_Type());
			ps.setInt(7, transaction.getAccnt_No());

			result = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// Function to update a record
	@Override
	public int updateRecord(Transaction transaction) {
		int result = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			// java.sql.Date transac_date=new
			// java.sql.Date(transaction.getTransac_Date().getTime());

			// To insert records
			PreparedStatement ps = con.prepareStatement(
					"update transaction set Amount=?,Transac_Date=?,Sender=?,Receiver=?,Transac_Type=?,Accnt_No=? where Transaction_Id=?");

			ps.setInt(1, transaction.getAmount());
			ps.setString(2, transaction.getTransac_Date());
			ps.setString(3, transaction.getSender());
			ps.setString(4, transaction.getReceiver());
			ps.setString(5, transaction.getTransac_Type());
			ps.setInt(6, transaction.getAccnt_No());
			ps.setInt(7, transaction.getTransaction_Id());

			result = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// Function to delete a record
	@Override
	public int deleteRecord(int Transaction_Id) {

		int result = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from transaction where Transaction_Id=?");

			ps.setInt(1, Transaction_Id);

			result = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// Function to fetch all record
	@Override
	public List<Transaction> getAllRecords() {

		ArrayList<Transaction> list = new ArrayList<>();
		try {
			Connection con = DatabaseConnection.getConnection();

			// To get all Records
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from transaction");
			// Add all Records in ArrayList

			while (rs.next()) {

				list.add(new Transaction(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));

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
	public Transaction getTransactionByTransaction_Id(int Transaction_Id) {
		Transaction transaction = null;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from transaction where Transaction_Id=?");
			ps.setInt(1, Transaction_Id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				transaction = new Transaction(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transaction;
	}

}
