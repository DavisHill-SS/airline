package ui;

import java.util.Scanner;

public class Main {
	public static void main_menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you");
		
		Integer input;
		String in;
		
		while(true) {
			System.out.println("1) for Employee");
			System.out.println("2) for Administrator");
			System.out.println("3) for Traveler");
			System.out.println("4) to exit");
			
			in = scan.next();
			
			try {
				input = Integer.parseInt(in);
				switch(input) {
				case 1:
					EmployeeMenu.Emp1();
					break;
				case 2:
					AdminMenu.Admin1();
					break;
				case 3:
					TravelerMenu.TravAuth();
					break;
				case 4:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Please enter 1, 2, 3, or 4");
					}
				}
			catch(Exception e){
				System.out.println("Please enter 1, 2, or 3");
			}

			
		}
		
	}
	
	public static void main(String[] args) {
		main_menu();
	}

}

