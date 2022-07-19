package com.obms.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.obms.services.AccountConnection;

public class IntegrationService {
   public String getAccount_Details_By_Cust_Id(String s ) {
	   String res1="null";
		try{
			Connection con=AccountConnection.getConnection();
			Statement stmt=con.createStatement();
			PreparedStatement ps=con.prepareStatement("select * from account inner join customer on account.Cust_ID=customer.Cust_ID");
			ps.setString(1,s);
			ResultSet res=ps.executeQuery();
			if(res.next()){
				   res1 = res.getString(1);
				}
			return res1;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return res1;
	   
   }
}
