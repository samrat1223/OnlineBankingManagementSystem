package com.obms.model;

public class Admin {
	
	private int Admin_ID;
	private String Admin_First_Name;
	private String Admin_Last_Name;
	private String Admin_Password;
	private String Admin_Email;
	private int Cust_ID;
	
	
	public int getAdmin_ID() {
		return Admin_ID;
	}
	public void setAdmin_ID(int admin_ID) {
		Admin_ID = admin_ID;
	}
	public String getAdmin_First_Name() {
		return Admin_First_Name;
	}
	public void setAdmin_First_Name(String admin_First_Name) {
		Admin_First_Name = admin_First_Name;
	}
	public String getAdmin_Last_Name() {
		return Admin_Last_Name;
	}
	public void setAdmin_Last_Name(String admin_Last_Name) {
		Admin_Last_Name = admin_Last_Name;
	}
	public String getAdmin_Password() {
		return Admin_Password;
	}
	public void setAdmin_Password(String admin_Password) {
		Admin_Password = admin_Password;
	}
	public String getAdmin_Email() {
		return Admin_Email;
	}
	public void setAdmin_Email(String admin_Email) {
		Admin_Email = admin_Email;
	}
	public int getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(int cust_ID) {
		Cust_ID = cust_ID;
	}
	
	public Admin(int admin_ID, String admin_First_Name, String admin_Last_Name, String admin_Password,
			String admin_Email, int cust_ID) {
		super();
		Admin_ID = admin_ID;
		Admin_First_Name = admin_First_Name;
		Admin_Last_Name = admin_Last_Name;
		Admin_Password = admin_Password;
		Admin_Email = admin_Email;
		Cust_ID = cust_ID;
	}
	
	

}
