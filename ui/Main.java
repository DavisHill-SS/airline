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
					emp();
					break;
				case 2:
					admin();
					break;
				case 3:
					trav();
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

	public void admin(){
		Integer input = 0;
		Scanner scan = new Scanner(System.in);
		while(input != 8) {
			System.out.println("1 to Add/Update/Delete/Read Flights");
			System.out.println("2 to Add/Update/Delete/Read Seats");
			System.out.println("3 to Add/Update/Delete/Read Tickets");
			System.out.println("4 to Add/Update/Delete/Read Airports");
			System.out.println("5 to Add/Update/Delete/Read Travelers");
			System.out.println("6 to Add/Update/Delete/Read Employees");
			System.out.println("7 to over-ride trip cancellation for a ticket");
			System.out.println("8 to return to main menu");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					//flights();
					break;
				case 2:
					//seats();
					break;
				case 3:
					//tickets();
					break;
				case 4:
					//airports();
					break;
				case 5:
					//travelers();
					break;
				case 6:
					//employees();
					break;
				case 7:
					//overrideCancellation();
					break;
				case 8:
					//Main main = new Main();
					//main.main_menu();
					main_menu();
					break;
				default:
					System.out.println("Please enter a number 1 through 8");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a number 1 through 8");
				//e.printStackTrace();
				}
			}
		scan.close();
		}
	
	public void emp() {
		Integer input = 0;
		Scanner scan = new Scanner(System.in);
		while(input != 3) {
			System.out.println("1 to enter new flights to manage");
			System.out.println("2 to list flights you currently manage");
			System.out.println("3 to quit to previous menu");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					manageNewFlight();
					break;
				case 2:
					//Flight flight = listFlights();
					//flightMenu(flight);
					break;
				case 3:
					main_menu();
					break;
				default:
					System.out.println("Please enter 1, 2, or 3");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter 1, 2, or 3");
				//e.printStackTrace();
			}

		}
		scan.close();
	}
	
	public void trav() {
		Integer input = 0;
		Scanner scan = new Scanner(System.in);
		while(input != 3) {
			System.out.println("1 to book a reservation");
			System.out.println("2 to cancel a reservation");
			System.out.println("3 to quit to previous menu");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					bookReservation();
					break;
				case 2:
					cancelReservation();
					break;
				case 3:
					main_menu();
					break;
				default:
					System.out.println("Please enter 1, 2, or 3");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter 1, 2, or 3");
				//e.printStackTrace();
			}

		}
		scan.close();
	}

}

