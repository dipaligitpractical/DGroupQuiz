package com.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.connection.ConnectionClass;
import com.quiz.main.designClass.BoxDesignClass;
import com.quiz.main.designClass.menuOfHomePage;
import com.registration.studentdetails.GetStudentDetails;
import com.scanner.ScannerClass;

public class StudentRegistrationForm {
		
	public static void studentRegistration() {
		BoxDesignClass.separator();
		System.out.println("\t\tWelcome in Registration Form ");
		BoxDesignClass.separator();
		 
		//get Student First Name
		System.out.println("Enter  Student First Name :   ");
		String name=GetStudentDetails.getStudentName();
		System.out.println("Enter  Student Last Name :   ");
		String sLastName=GetStudentDetails.getStudentName();
		
		System.out.println("Enter Student RollNo : ");
		String rNo=GetStudentDetails.getStudentRollNo();
		System.out.println(" 1. SUBMIT \t||\t 2. CANCLE");
		System.out.println("Do you want Submit Registration (y/n)");
		String response=new ScannerClass().sc.next();
		if(response.equalsIgnoreCase("y"))
		{

			Connection con=ConnectionClass.getConnection();
			String sql="insert into studentRegistration (sName,sLastName,sRollNo)values(?,?,?)";
			try {
				PreparedStatement psmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				/* save data student registration details in database*/
				psmt.setString(1, name); 
				psmt.setString(2, sLastName);
				psmt.setString(3, rNo);
				int result=psmt.executeUpdate();
				/* get auto generated id*/
				//if()
				ResultSet key=psmt.getGeneratedKeys();
				key.next();
				int id=key.getInt(1);
				if(result!=0) {
					System.out.println("\t\t\tRegistration Done Successfully");
					//save student new generated username and password in studentLoginDetails
					SaveLoginDetails.auto_SaveLoginInfo(id, name, sLastName);
				}
				else
					System.out.println("\t\t\tRegistration Fail ,Please Try After some time");
			} catch (SQLException e) {
				
				System.out.println("Server Loading....");
			}
		}
		else {
			System.out.println("\t\t\tYour Registration is Fail");
			menuOfHomePage.mainMenu();
		}
		
	}

}
