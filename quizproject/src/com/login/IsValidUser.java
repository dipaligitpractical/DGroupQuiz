package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.ConnectionClass;
import com.exam.QiuzForm;
import com.quiz.main.designClass.BoxDesignClass;
import com.quiz.main.designClass.menuOfHomePage;
import com.registration.MenuOfRegistration;
import com.scanner.ScannerClass;

public class IsValidUser {

	public static void isValid() {
		System.out.println("Enter user name :");
		String uname=new ScannerClass().sc.nextLine();
		System.out.println("Enter Password :");
		String pwd=new ScannerClass().sc.next();
		boolean flag=IsPasswordPresent.isPassword(pwd);
		if(flag) {
		String sql="select userName,sId from studentLoginDetails where sPassword=?";
		Connection connection=ConnectionClass.getConnection();
		try {
			PreparedStatement  psmt=connection.prepareStatement(sql);
			psmt.setString(1, pwd);
			ResultSet checkDetails=psmt.executeQuery();
			   while(checkDetails.next()) {
					String name=checkDetails.getString(1);
					int stuId=checkDetails.getInt(2);
					if(name.equals(uname)) {
						//user is valid student call exam form
						BoxDesignClass.separator();
						System.out.println("\t\t\t\t\tYour Exam is Starting");
						//BoxDesignClass.separator();
						MenuOfRegistration.quizDetails();
						BoxDesignClass.separator();
						QiuzForm.quizApplication(stuId,name);
					}
					else
					{
						System.out.println("\t\t\t\t INVALID USER NAME DATA,");
						System.out.println("\t\t\t\tDO YOU WANT TO CONTINUE(Y/N)");
						String choice=new ScannerClass().sc.next();
						if(choice.equalsIgnoreCase("y"))
							isValid();
						else
							menuOfHomePage.mainMenu();
					}
			   }
			
		} catch (SQLException e) {
			
			System.out.println("There are some Confict occures,Reload page"+e.toString());
		}		
		}
		else
		{
			System.out.println("\t\t\tINVALID USER");
			menuOfHomePage.mainMenu();
			
		}
	}
}
