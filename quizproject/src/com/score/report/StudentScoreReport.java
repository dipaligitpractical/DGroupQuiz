package com.score.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.connection.ConnectionClass;
import com.quiz.main.designClass.menuOfHomePage;
import com.quizthread.QuizThread;

public class StudentScoreReport {
	public static boolean areRecords()
	{
		Connection connection=ConnectionClass.getConnection();
		String sql="select count(*) from studentResults";
		try {
			PreparedStatement psmt=connection.prepareStatement(sql);
			ResultSet studentResult=psmt.executeQuery();
			while(studentResult.next()) 
			if(studentResult.getInt("count(*)")==0)
				return false;
			
		} catch (SQLException e) {
			
			System.out.println("Server Busy........,try after some time");
		}
		return true;
	}
	
	public static void scoreReport() {
		boolean flag=areRecords();
		if(flag) {
			Connection connection=ConnectionClass.getConnection();
			try {
				Statement smt=connection.createStatement();
				String sql=" select * from studentResults order by sScore desc";
				ResultSet studentResult=smt.executeQuery(sql);
				System.out.println("------------------------------");
				System.out.println("STUDENT RESULT LIST");
				System.out.println("------------------------------");
				System.out.println("ID\t"+"Name\t"+"\tScore");
				while(studentResult.next()) {
					System.out.println(studentResult.getInt(1)+"\t"+studentResult.getString(2)+"\t"+studentResult.getInt(3));
				}
				System.out.println("------------------------------");
				}
			catch (SQLException e) {
			
			System.out.println("Server Loading");
		}}
		else {
			
			QuizThread quizThread=new QuizThread();
			quizThread.start();
			System.out.println("There are no any Record Available");
			menuOfHomePage.mainMenu();
		}
				
	}
	
}
