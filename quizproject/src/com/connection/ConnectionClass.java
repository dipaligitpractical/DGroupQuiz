package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	public static Connection getConnection() {
		Connection connection=null;
		try {
			//load jdbc Driver
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/quizdb?characterEncoding=utf8";
			try {
			
				connection=DriverManager.getConnection(url,"root","root");
				}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	
}
