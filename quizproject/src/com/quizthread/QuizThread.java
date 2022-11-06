package com.quizthread;

public class QuizThread extends Thread {

	@Override
	public void run() {
		//System.out.println("server loading");
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(10000);
			}
			catch (InterruptedException e) {
				System.out.println("Weak Network");
			}
		}
		
	}
	

}
