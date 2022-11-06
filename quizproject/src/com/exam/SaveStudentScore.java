package com.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.connection.ConnectionClass;

public class SaveStudentScore {
	public static void studentScore(int sid,String name,int score) {
		Connection connection=ConnectionClass.getConnection();
		//studentResults(Id ,sFullName,sScore)
		String sql="insert into studentResults(Id ,sFullName,sScore) values(?,?,?)";
		try {
			PreparedStatement psmt=connection.prepareStatement(sql);
			psmt.setInt(1, sid);
			psmt.setString(2, name);
			psmt.setInt(3, score);
			psmt.execute();
		} catch (SQLException e) {
			System.out.println("Your ReAttempt Exam,so Its Invalid");
		}
		
	}
	

}
