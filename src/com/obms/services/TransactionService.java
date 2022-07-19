package com.obms.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.obms.model.Transaction;
import com.obms.services.TransactionConnection;

public class TransactionService implements TransactionCrud {

	@Override
	public int insertRecord(Transaction transaction) {
		int result=0;
		try{
			Connection con=TransactionConnection.getConnection();
			java.sql.Date transac_date=new java.sql.Date(transaction.getTransac_Date().getTime());
			
			//To insert records 
			PreparedStatement ps=con.prepareStatement("insert into transaction(Transaction_Id,Amount,Transac_Date,Sender,Receiver,Transac_Type,Accnt_No) values(?,?,?,?,?,?,?)");
			ps.setInt(1,transaction.getTransaction_Id());
			ps.setInt(2,transaction.getAmount());
			ps.setDate(3, transac_date);
			ps.setString(4,transaction.getSender());
			ps.setString(5,transaction.getReceiver());
			ps.setString(6,transaction.getTransac_Type());
			ps.setInt(7,transaction.getAccnt_No());
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
	}

	@Override
	public int updateRecord(Transaction transaction) {
		int result=0;
		try{
			Connection con=TransactionConnection.getConnection();
			java.sql.Date transac_date=new java.sql.Date(transaction.getTransac_Date().getTime());
			
			//To insert records 
			PreparedStatement ps=con.prepareStatement("update transaction set Amount=?,Transac_Date=?,Sender=?,Receiver=?,Transac_Type=?,Accnt_No=? where Transaction_Id=?");
			
			ps.setInt(1,transaction.getAmount());
			ps.setDate(2, transac_date);
			ps.setString(3,transaction.getSender());
			ps.setString(4,transaction.getReceiver());
			ps.setString(5,transaction.getTransac_Type());
			ps.setInt(6,transaction.getAccnt_No());
			ps.setInt(7,transaction.getTransaction_Id());
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
	}

	@Override
	public int deleteRecord(int Transaction_Id) {
		
		int result=0;
		try{
			Connection con=TransactionConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from transaction where Transaction_Id=?");
			
			ps.setInt(1,Transaction_Id);
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public List<Transaction> getAllRecords() {
		
		ArrayList<Transaction> list=new ArrayList<>();
		try{
		Connection con=TransactionConnection.getConnection();
		
		//To get all Records
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from transaction");
		//Add all Records in ArrayList		
						
		while(rs.next()) {
			
			list.add(new Transaction(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			
					
		}
		stmt.close();
		con.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Transaction getTransactionByTransaction_Id(int Transaction_Id) {
		Transaction transaction=null;
		try{
			Connection con=TransactionConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from transaction where Transaction_Id=?");
			ps.setInt(1, Transaction_Id);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				transaction=new Transaction(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
			
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return transaction;
	}
	
	

}
