package users;

import java.util.Scanner;

import entity.Flight;

public class Employee {
	
	public Employee() {

	}
	
	public void menu() {
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
	
	public void flightMenu(Flight flight) {
		Integer input = 0;
		Scanner scan = new Scanner(System.in);
		while(input != 3) {
			System.out.println("1 to view details of the flight");
			System.out.println("2 to update details of the flight");
			System.out.println("3 to add seats to flight");
			System.out.println("4 to quit to previous menu");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					viewFlight(flight);
					break;
				case 2:
					updateFlight(flight);
					break;
				case 3:
					addSeats(flight);
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
	
	public void manageNewFlight() {
		
		
	}
	
	public Flight listFlights() {
		//retrieve flights where flight -> flight_booking booking_id == booking id of booking_agent
		Flight flight = new Flight();
		return flight;
	}
	
	public void updateFlight(Flight flight) {
		//list properties of flight
		//take user input on properties to change
	}
	
	public void viewFlight(Flight flight) {
		//list properties of flight
		
	}
	
	public void addSeats(Flight flight) {
		//take user input on how much seats to add
		//add seats
		
	}

}
