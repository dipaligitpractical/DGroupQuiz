package com.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.connection.ConnectionClass;

public class IsPasswordPresent {

	public static boolean isPassword(String pwd){
		
		Connection connection=ConnectionClass.getConnection();
		Statement smt;
		ArrayList<String>pwdList=new ArrayList<String>();
		String sql="select sPassword from studentLoginDetails";
		try {
			 smt=connection.createStatement();
			 ResultSet passwordFiled=smt.executeQuery(sql);
			 while(passwordFiled.next()) {
				 pwdList.add(passwordFiled.getString(1));
			 }
			 if(pwdList.contains(pwd))
				 return true;
		} catch (SQLException e) {
			System.out.println("Invalid Information");
		}
		return false;
		
	}
	
}
