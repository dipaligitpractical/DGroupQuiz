package com.registration;

import com.quiz.main.designClass.BoxDesignClass;
import com.quiz.main.designClass.menuOfHomePage;
import com.scanner.ScannerClass;

public class MenuOfRegistration {

	public static void quizDetailsControl() {
		quizDetails();
		BoxDesignClass.ButtonTop();
		System.out.println("\t\t     Exit      ");
		BoxDesignClass.ButtonBottom();
		
		BoxDesignClass.separator();
		System.out.println("\t Press Any Key For Exit");
		new ScannerClass().sc.next();	
		menuOfHomePage.mainMenu();
}
	public static void quizDetails() {
		System.out.println("1. Read Instruction CareFully");
		System.out.println("2. All Questions are compulsory");
		System.out.println("3. Each Question Carry One Mark");		
	}

}
