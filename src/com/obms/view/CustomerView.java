package com.obms.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.obms.controller.CustomerController;
import com.obms.model.Customer;

public class CustomerView {
	
	public static int customerview() throws Exception {
        CustomerController customerctrl = new CustomerController();
        int result;
       Customer customer= new Customer();
        
    	int Cust_ID;
        String Cust_Address;
        String Cust_Name;
        String Cust_Password;
        String Cust_Aadharno;
        String Cust_Panno;
        String Cust_Email;
        int Cust_MobileNo;
        int Cust_PinCode;
        String Cust_State;
        String User_Name;
        String Cust_NomineeName;
        String Cust_DOB;
        int Accnt_No;
        
        int choice;
        boolean ch=true;
	while(ch){
            System.out.println("1. Add Record");
            System.out.println("2. Update Record");
            System.out.println("3. Delete Record");
            System.out.println("4. View Records");
            System.out.println("5. View a Record");
            System.out.println("0. Exit ");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {
    		case 1:
    			System.out.println("Enter the Cust_ID,Cust_Name,Cust_Aadharno,Cust_Address,Cust_Panno,Cust_Email,Cust_Password,Cust_MobileNo,Cust_PinCode,Cust_State,User_Name,Cust_DOB,Accnt_No,Cust_NomineeName");
    			Cust_ID= sc.nextInt();
    			sc.nextLine();
    			Cust_Name= sc.next();
    			sc.nextLine();
    			Cust_Aadharno=sc.next();
                sc.nextLine();
    			Cust_Address= sc.next();
    			sc.nextLine();	
    			  Cust_Panno=sc.next();
                  sc.nextLine();
                  Cust_Email=sc.next();
                  sc.nextLine();
    			Cust_Password= sc.nextLine();
    			sc.nextLine();
               Cust_MobileNo=sc.nextInt();
                sc.nextLine();
                Cust_PinCode=sc.nextInt();
                sc.nextLine();
                Cust_State=sc.next();
                sc.nextLine();
                User_Name=sc.next();
                sc.nextLine();
                Cust_DOB= sc.next();//new SimpleDateFormat("yyyy-MM-dd").parse(sc.next());
                sc.nextLine();
                Accnt_No=sc.nextInt();
                sc.nextLine();
                Cust_NomineeName=sc.next();
                sc.nextLine();
               
                

    			 customer= new Customer(Cust_ID,Cust_Address,Cust_Name,Cust_Password,Cust_Aadharno,Cust_Panno,Cust_Email,Cust_MobileNo,Cust_PinCode,Cust_State,User_Name,Cust_NomineeName,Cust_DOB,Accnt_No);
    			result = customerctrl.insertRecord(customer);
    			if (result > 0)
    				System.out.println("Record Inserted");
    			else
    				System.out.println("Record not inserted");
    			break;
    			
    		case 2:
    			System.out.println("Enter the Cust_ID,Cust_Address,Cust_Name,Cust_Password,Cust_Aadharno,Cust_Panno,Cust_Email,Cust_MobileNo,Cust_PinCode,Cust_State,User_Name,Cust_NomineeName,Cust_DOB,Accnt_No");
    			Cust_ID= sc.nextInt();
    			sc.nextLine();
    			Cust_Address= sc.next();
    			sc.nextLine();
    			Cust_Name= sc.next();
    			Cust_Password= sc.next();
                Cust_Aadharno=sc.next();
                Cust_Panno=sc.next();
                sc.nextLine();
                Cust_Email=sc.next();
                sc.nextLine();
                Cust_MobileNo=sc.nextInt();
                sc.nextLine();
                Cust_PinCode=sc.nextInt();
                sc.nextLine();
                Cust_State=sc.next();
                sc.nextLine();
                User_Name=sc.next();
                sc.nextLine();
                Cust_NomineeName=sc.next();
                sc.nextLine();
                Cust_DOB=sc.next();//new SimpleDateFormat("yyyy-MM-dd").parse(sc.next());
                sc.nextLine();
                Accnt_No=sc.nextInt();

    			customer= new Customer(Cust_ID,Cust_Address,Cust_Name,Cust_Password,Cust_Aadharno,Cust_Panno,Cust_Email,Cust_MobileNo,Cust_PinCode,Cust_State,User_Name,Cust_NomineeName,Cust_DOB,Accnt_No);
    			result = customerctrl.updateRecord(customer);
    			if (result > 0)
    				System.out.println("Record updated");
    			else
    				System.out.println("Record not found");
    			break;

		case 3:
			System.out.println("Enter the Cust_ID");
			Cust_ID= sc.nextInt();
			result = customerctrl.deleteRecord(Cust_ID);
			if (result > 0)
				System.out.println("Record deleted");
			else
				System.out.println("Record not found");
			break;
			
		case 4:
			List<Customer> list= customerctrl.getAllRecords();
			
		if(list.size()==0)
			{
				System.out.println("No records found");
			}
			else 
			{
			for(Customer cus : list){
				System.out.println(cus.getCust_ID()+"\t"+cus.getCust_Address()+"\t"+cus.getCust_Name()+"\t"+cus.getCust_Password()+"\t"+cus.getCust_Aadharno()+"\t"+cus.getCust_Email()+"\t"+cus.getCust_MobileNo()+"\t"+
						cus.getCust_PinCode()+"\t"+cus.getCust_State()+"\t"+cus.getUser_Name()+"\t"+cus.getCust_NomineeName()+"\t"+cus.getCust_DOB()+"\t"+
						cus.getAccnt_No());
			}
			}
		break;
		
		case 5:
			System.out.println("Enter Cust_ID");
			Cust_ID=sc.nextInt();
			customer=customerctrl.getCustomerByCust_ID(Cust_ID);
			System.out.println("Cust_ID="+customer.getCust_ID());
			System.out.println("Cust_Address="+customer.getCust_Address());
			System.out.println("Cust_Name="+customer.getCust_Name());
			System.out.println("Cust_Password="+customer.getCust_Password());
			System.out.println("Cust_AadharNo="+customer.getCust_Aadharno());
			System.out.println("Cust_Panno="+customer.getCust_Panno());
			System.out.println("Cust_Email="+customer.getCust_Email());
			System.out.println("Cust_PhoneNo="+customer.getCust_MobileNo());
			System.out.println("Cust_PinCode="+customer.getCust_PinCode());
			System.out.println("Cust_State="+customer.getCust_State());
			System.out.println("Cust Name="+customer.getUser_Name());
			System.out.println("Cust_Nominee Name="+customer.getCust_NomineeName());
			System.out.println("Cust DOB="+customer.getUser_Name());
			System.out.println("Cust Accnt_No="+customer.getAccnt_No());
			
			break;
			case 0: 
				ch=false;
			break;

		}
            
	}
	return 0;
	}

}
