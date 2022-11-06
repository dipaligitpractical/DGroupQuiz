package com.registration.studentdetails;

import com.scanner.ScannerClass;

public class GetStudentDetails {
	//is student name valid or not
		public static String getStudentName() {
			boolean flag=true;
		
			String str=new ScannerClass().sc.next();
			for(int i=0;i<str.length();i++) {
				if(!(str.charAt(i)>=65&&str.charAt(i)<=90 ||str.charAt(i)>=97&&str.charAt(i)<=122)) {
					flag=false;
				}
			}
			if(flag)
				return str;
			else {
				str=null;
				System.out.println("Enter valid name");
				str=getStudentName();
			}
			//sc.close();
			return str;
				
		}
		//student roll no valid or not
		public static String getStudentRollNo() {
			boolean flag=true;
			
			String num=new ScannerClass().sc.next();
			for(int i=0;i<num.length();i++) {
				if(!(num.charAt(i)>=47&&num.charAt(i)<=57)) {
					flag=false;
				}
			}
			if(flag)
				return num;
			else{
				num=null;
				System.out.println("Enter valid rollNo number");
				num=getStudentRollNo();
			}
			
			return num;
		}
	
}
