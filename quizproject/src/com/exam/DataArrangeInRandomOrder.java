package com.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.connection.ConnectionClass;

public class DataArrangeInRandomOrder {
	
	public static HashMap<HashMap<String,ArrayList<String>>,String>randomlyData(){
		//connection 
	Connection connection=ConnectionClass.getConnection();
	String sql="Select question,op1,op2,op3,op4,correctAns from questions";
	HashMap<HashMap<String, ArrayList<String>>,String>mainMap=new HashMap<HashMap<String, ArrayList<String>>, String>();
	
	try {
		PreparedStatement psmt=connection.prepareStatement(sql);
		ResultSet record=psmt.executeQuery();
		//data Stored in hash map (purpose to get data in random order)
		while(record.next()) {
			ArrayList<String>option=new ArrayList<String>(); 
			HashMap<String,ArrayList<String>>map=new HashMap<String, ArrayList<String>>();
			//get question
			String que=record.getString(1);
			//get option
			option.add(record.getString(2));
			option.add(record.getString(3));
			option.add(record.getString(4));
			option.add(record.getString(5));
			//set que and option in map
			map.put(que,option );
			String ans=record.getString(6);
			//set map as key and ans as a value in mainMap
			mainMap.put(map, ans);
				}
		
		} catch (SQLException e) {
			System.out.println("Some Loading Problem,Try again"+e.toString());
		}
		return mainMap;
	}
	
}
