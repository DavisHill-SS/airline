package ui;

import java.util.Scanner;

import users.Administrator;
import users.Employee;
import users.Traveler;

public class Main {
	public void main_menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you");
		
		Integer input = 0;
		while(input != 4) {
			System.out.println("1 for Employee");
			System.out.println("2 for Administrator");
			System.out.println("3 for Traveler");
			System.out.println("4 to exit");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					Employee emp = new Employee();
					emp.menu();
					break;
				case 2:
					Administrator admin = new Administrator();
					admin.menu();
					break;
				case 3:
					Traveler trav = new Traveler();
					trav.menu();
					break;
				default:
					System.out.println("Please enter 1, 2, 3, or 4");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter 1, 2, 3, or 4");
				e.printStackTrace();
			}

			
		}
		scan.close();
		System.out.println("Exiting Airline Management System...");

	}
	public static void main(String[] args) {
		Main main = new Main();
		main.main_menu();


}

}

