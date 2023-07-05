package src.demo;

import src.main.UserInputHandler;


public class shopingApp {

	public static void main(String[] args) {
		boolean flag = true;
		UserInputHandler userInputHandler = new UserInputHandler();
		
		while(flag){

			System.out.println("===================================================");
			System.out.println("================Shoper Stop=========================");
			System.out.println("===================================================");
			
			flag = userInputHandler.menu();
		}
		
		System.out.println("We will Miss you");
		
	}

}
