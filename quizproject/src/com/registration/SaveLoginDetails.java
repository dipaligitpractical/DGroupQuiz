package com.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.connection.ConnectionClass;
import com.quiz.main.designClass.BoxDesignClass;
import com.quiz.main.designClass.menuOfHomePage;

public class SaveLoginDetails {
	public static void auto_SaveLoginInfo(int id,String fName,String lName) {
		//auto generate user name
		int sid=id;
		String userName=fName+" "+lName;
		//user password
		String pwd=fName+lName+id;
		//get connection
		PreparedStatement psmt;
		Connection connection=ConnectionClass.getConnection();
		
		try {
			String sql="insert into studentLoginDetails(sId,userName,sPassword)values(?,?,?)";
			 psmt=connection.prepareStatement(sql);
			 psmt.setInt(1, sid);
			 psmt.setString(2, userName);
			 psmt.setString(3, pwd);
			 int rowAffected=psmt.executeUpdate();
				if(rowAffected!=0) {
					BoxDesignClass.separator();
					System.out.println("\t\t\tYour user id is :"+sid);
					System.out.println("\t\t\tYour user name is:"+userName);
					System.out.println("\t\t\tPassword is :"+pwd);
					System.out.println("\t\t\tMust used this information for Login ");
					menuOfHomePage.mainMenu();
				}
				
		} catch (SQLException e) {
			
			System.out.println("There are some Network problem,Please Reload Page");
		}
				
	}
	
}
