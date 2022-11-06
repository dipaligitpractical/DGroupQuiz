package com.quiz.main.designClass;
import com.login.LoginHomePage;
import com.registration.MenuOfRegistration;
import com.registration.StudentRegistrationForm;
import com.scanner.ScannerClass;
import com.score.report.GetParticularStudentReport;
import com.score.report.StudentScoreReport;

public class menuOfHomePage {
	
	public static void mainMenu() {
		BoxDesignClass.separator();
		System.out.println("1.Registration\t||\t 2.Quiz Details\t||\t 3.Login \t ||\t4.StudentRecord\t||\t5.Record\t||\t6.Exit");
		BoxDesignClass.separator();
		System.out.println("Enter your Choice  :");
		subPartOfMainMenu();
			
	}
	public static void subPartOfMainMenu() {
		//options is 1.Registration  2.Quiz Details  3.Login
				
				int choice=new ScannerClass().sc.nextInt(); 
				if(choice==1) 
					//goto Registration form
					StudentRegistrationForm.studentRegistration();
				else if(choice==2)
					MenuOfRegistration.quizDetailsControl();  //quiz information
				else if(choice==3)
					LoginHomePage.userLoginForm();//quiz exam form
				else if(choice==4) {
					StudentScoreReport.scoreReport();
					mainMenu();
				}
				else if(choice==5) {
					GetParticularStudentReport.particularStudentReport();
					mainMenu();
				}
				else if(choice==6) {
					System.out.println("Thanks For visiting QUIZ Site");
					System.exit(0);
				}
				else
				{
					System.out.println("Enter Valid Details");
					subPartOfMainMenu();
				}	
	}
}

