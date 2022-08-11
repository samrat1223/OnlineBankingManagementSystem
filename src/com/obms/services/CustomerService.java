package com.obms.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.obms.model.Customer;
import com.obms.services.DatabaseConnection;

// Service class to implement crud operations
public class CustomerService implements CustomerCrud {

	// Method to insert records
	@Override
	public int insertRecord(Customer customer) {

		int result = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			// java.sql.Date Cust_dob=new java.sql.Date(customer.getCust_DOB().getTime());
			PreparedStatement ps = con.prepareStatement(
					"insert into customer(Cust_ID,Cust_Name,Cust_Aadharno,Cust_Address,Cust_Panno,Cust_Email,Cust_Password,Cust_MobileNo,Cust_PinCode,Cust_State,User_Name,Cust_DOB,Accnt_No,Cust_NomineeName) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

			ps.setInt(1, customer.getCust_ID());
			ps.setString(2, customer.getCust_Name());
			ps.setString(3, customer.getCust_Aadharno());
			ps.setString(4, customer.getCust_Address());
			ps.setString(5, customer.getCust_Panno());
			ps.setString(6, customer.getCust_Email());
			ps.setString(7, customer.getCust_Password());
			ps.setInt(8, customer.getCust_MobileNo());
			ps.setInt(9, customer.getCust_PinCode());
			ps.setString(10, customer.getCust_State());
			ps.setString(11, customer.getUser_Name());
			ps.setString(12, customer.getCust_DOB());
			ps.setInt(13, customer.getAccnt_No());
			ps.setString(14, customer.getCust_NomineeName());

			result = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// Method to update records
	@Override
	public int updateRecord(Customer customer) {
		int result = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			// java.sql.Date Cust_dob=new java.sql.Date(customer.getCust_DOB().getString());
			PreparedStatement ps = con.prepareStatement(
					"update customer set Cust_Name=?,Cust_Aadharno=?,Cust_Address=?,Cust_Panno=?,Cust_Email=?,Cust_Password=?,Cust_MobileNo=?,Cust_PinCode=?,Cust_State=?,User_Name=?,Cust_DOB=?,Accnt_No=?,Cust_NomineeName=? where Cust_ID=?");

			ps.setString(1, customer.getCust_Name());
			ps.setString(2, customer.getCust_Aadharno());
			ps.setString(3, customer.getCust_Address());
			ps.setString(4, customer.getCust_Panno());
			ps.setString(5, customer.getCust_Email());
			ps.setString(6, customer.getCust_Password());
			ps.setInt(7, customer.getCust_MobileNo());
			ps.setInt(8, customer.getCust_PinCode());
			ps.setString(9, customer.getCust_State());
			ps.setString(10, customer.getUser_Name());
			ps.setString(11, customer.getCust_DOB());
			ps.setInt(12, customer.getAccnt_No());
			ps.setString(13, customer.getCust_NomineeName());
			ps.setInt(14, customer.getCust_ID());
			result = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// Method to delete records
	@Override
	public int deleteRecord(int Cust_ID) {
		int result = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from customer where Cust_ID=?");

			ps.setInt(1, Cust_ID);

			result = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// Method to list all the records
	@Override
	public List<Customer> getAllRecords() {
		ArrayList<Customer> list = new ArrayList<>();
		try {
			Connection con = DatabaseConnection.getConnection();

			String sql = "select * from customer";
			// To get all Records
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// Add all Records in ArrayList

			while (rs.next()) {

				Customer cust = new Customer();
				cust.setCust_ID(rs.getInt(1));
				cust.setCust_Name(rs.getString(2));
				cust.setCust_Aadharno(rs.getString(3));
				cust.setCust_Address(rs.getString(4));
				cust.setCust_Panno(rs.getString(5));
				cust.setCust_Email(rs.getString(6));
				cust.setCust_Password(rs.getString(7));
				cust.setCust_MobileNo(rs.getInt(8));
				cust.setCust_PinCode(rs.getInt(9));
				cust.setCust_State(rs.getString(10));
				cust.setUser_Name(rs.getString(11));
				cust.setCust_DOB(rs.getString(12));
				cust.setAccnt_No(rs.getInt(13));
				cust.setCust_NomineeName(rs.getString(14));
				list.add(cust);
				// list.add(new
				// Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),rs.getInt(7),
				// rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getDate(13),rs.getInt(14)));

			}
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Method to fetch a particular record
	@Override
	public Customer getCustomerByCust_ID(int Cust_ID) {

		Customer cust = null;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from customer where Cust_ID=?");
			ps.setInt(1, Cust_ID);
			ResultSet rs = ps.executeQuery();
			// System.out.println(rs.next());
			if (rs.next()) {
				// customer=new
				// Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),rs.getInt(7),
				// rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getInt(14));
				cust = new Customer();

				cust.setCust_ID(rs.getInt(1));
				cust.setCust_Name(rs.getString(2));
				cust.setCust_Aadharno(rs.getString(3));
				cust.setCust_Address(rs.getString(4));
				cust.setCust_Panno(rs.getString(5));
				cust.setCust_Email(rs.getString(6));
				cust.setCust_Password(rs.getString(7));
				cust.setCust_MobileNo(rs.getInt(8));
				cust.setCust_PinCode(rs.getInt(9));
				cust.setCust_State(rs.getString(10));
				cust.setUser_Name(rs.getString(11));
				cust.setCust_DOB(rs.getString(12));
				cust.setAccnt_No(rs.getInt(13));
				cust.setCust_NomineeName(rs.getString(14));

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}

}
