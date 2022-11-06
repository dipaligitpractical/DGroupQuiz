package com.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.quiz.main.designClass.BoxDesignClass;
import com.quiz.main.designClass.menuOfHomePage;
import com.scanner.ScannerClass;

public class DesignOfQuestionForm {
	public static void getFormDesign(int sid,String sname) {
		HashMap<HashMap<String,ArrayList<String>>,String> randomData=new HashMap<HashMap<String, ArrayList<String>>, String>();
		//used for to sort data randamly
		randomData=DataArrangeInRandomOrder.randomlyData();
		//variables
		int queCounter=0;
		int marks=0;
		char OptHead=65;
		
		String ans; //used to stored correct answer that fectch from database
	
		for(Entry<HashMap<String, ArrayList<String>>, String> record: randomData.entrySet())
		{
			//key data of outer HashMap
			Map<String, ArrayList<String>> outerMapkeyRecord=record.getKey();
			
			String correctAns=record.getValue();
		
			//to get key and value data of inner map
			for(Entry<String ,ArrayList<String>> innerMapRecord:outerMapkeyRecord.entrySet())
			{
				queCounter++;
				String inKey=innerMapRecord.getKey();//key of inner map
				System.out.println(queCounter+" . "+inKey); //display question on console
				System.out.println("Options:");
				//get option data (value of  inner map)
				ArrayList<String>list=innerMapRecord.getValue();
				//code for display option
				for(String options:list) { 
					System.out.println(Character.valueOf(OptHead)+". "+options);
					OptHead++;
				}
				System.out.println("Select Your Answer :");
				ans=new ScannerClass().sc.next();
				
				OptHead=65;
				if(ans.equalsIgnoreCase(correctAns))
					marks++;
				BoxDesignClass.separator();
			}
			
			}
			if(queCounter==10){
				System.out.println("Your Exam Submitted Successfully ");
				SaveStudentScore.studentScore(sid, sname, marks);
				System.out.println("View Score (y/n):");
				String choice=new ScannerClass().sc.next();
				if(choice.equalsIgnoreCase("y")) {
					System.out.println("\tYour Score is:"+marks+"out of 10");
					if(marks>8&&marks<=10)
						System.out.println("\t\t Grade :Class-A");
					else if(marks>6&&marks<=8)
						System.out.println("\t\t Grade :Class-B");
					else if(marks>=5&&marks<=6)
						System.out.println("\t\t Grade :Class-B");
				}
				else
					System.out.println("\t\t Your are Fail");
			}
			menuOfHomePage.mainMenu();
		
	}
	
	}

