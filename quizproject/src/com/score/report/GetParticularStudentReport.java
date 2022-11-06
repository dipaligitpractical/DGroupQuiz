package com.score.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.connection.ConnectionClass;
import com.quiz.main.designClass.menuOfHomePage;
import com.scanner.ScannerClass;

public class GetParticularStudentReport {
	
	public static void particularStudentReport() {
		Connection connection=ConnectionClass.getConnection();
		String sql="select * from studentResults where id=?";
		try {
			PreparedStatement psmt=connection.prepareStatement(sql);
			System.out.println("Enter student Id");
			int id=new ScannerClass().sc.nextInt();
			Boolean flag=isRecord(id);
			if(flag) {
			
				psmt.setInt(1, id);
				ResultSet studentResult=psmt.executeQuery();
				System.out.println("Student Result:");
				System.out.println("------------------------------");
				System.out.println("ID\t"+"  Name\t"+"\tScore");
				System.out.println("------------------------------");
				while(studentResult.next()) {
					System.out.println(studentResult.getInt(1)+"\t"+studentResult.getString(2)+"\t"+studentResult.getInt(3));
				}
			System.out.println("------------------------------");
			}
			else {
				System.out.println("Invalid  Id");
				System.out.println("There is no any Record Available");
				menuOfHomePage.mainMenu();
			//	particularStudentReport();
				
			}
		} catch (SQLException e) {
			
			System.out.println("Server Busy........,try after some time");
		}
				
	}
	//get check record is available or not
	public static boolean isRecord(int id)
	{
		Connection connection=ConnectionClass.getConnection();
		String sql="select count(*) from studentResults where id=?";
		try {
			PreparedStatement psmt=connection.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet studentResult=psmt.executeQuery();
			while(studentResult.next()) 
			if(studentResult.getInt("count(*)")==0)
				return false;
			
		} catch (SQLException e) {
			
			System.out.println("Server Busy........,try after some time");
		}
		return true;
	}
	}
