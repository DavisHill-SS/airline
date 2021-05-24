package users;

import java.util.List;
import java.util.Scanner;
import entity.*;
import dao.*;
import service.*;
import ui.Main;

public class Administrator {
	
	public Administrator(){

		}
	
	public void menu() {
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
					flights();
					break;
				case 2:
					seats();
					break;
				case 3:
					tickets();
					break;
				case 4:
					airports();
					break;
				case 5:
					travelers();
					break;
				case 6:
					employees();
					break;
				case 7:
					//overrideCancellation();
					break;
				case 8:
					Main main = new Main();
					main.main_menu();
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
	
	public void flights() {
		Scanner scan = new Scanner(System.in);
		Integer input = 0;
		while(input != 6) {
			System.out.println("1 to add");
			System.out.println("2 to update");
			System.out.println("3 to delete");
			System.out.println("4 to read");
			System.out.println("5 to read all");
			System.out.println("6 to return to previous menu");
			try {
				input = scan.nextInt();
				FlightService service = new FlightService();
				Flight flight;
				Integer id;
				List<Flight> flights;
				switch(input) {
				case 1:
					id = -1;
					flight = new Flight(id);
					service.addFlight(flight);
					break;
				case 2:
					System.out.println("Enter flight_id of flight you want to update");
					id = scan.nextInt();
					flight = new Flight(id);
					service.updateFlight(flight);
					break;
				case 3:
					System.out.println("Enter flight_id of flight you want to delete");
					id = scan.nextInt();
					flight = new Flight();
					flight.setId(id);
					service.deleteFlight(flight);
					break;
				case 4:
					System.out.println("Enter flight_id of flight you want to read");
					id = scan.nextInt();
					flight = new Flight();
					flight.setId(id);
					flights = service.getFlight(flight);
					for(Flight f: flights) {
						System.out.println(f.toString());
					}
					break;
				case 5:
					flights = service.getAllFlights();
					for(Flight f: flights) {
						System.out.println(f.toString());
					}
					break;
				case 6:
					service = null;
					System.gc();
					break;
				default:
					System.out.println("Please enter a number 1 through 6");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a number 1 through 6");
				}
			}
		scan.close();
	}
	
	public void seats() {
		Scanner scan = new Scanner(System.in);
		Integer input = 0;
		while(input != 6) {
			System.out.println("1 to add");
			System.out.println("2 to update");
			System.out.println("3 to delete");
			System.out.println("4 to read");
			System.out.println("5 to read all");
			System.out.println("6 to return to previous menu");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
					System.out.println("Please enter a number 1 through 6");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a number 1 through 6");
				}
			}
		scan.close();
	}
	
	public void tickets() {
		Scanner scan = new Scanner(System.in);
		Integer input = 0;
		while(input != 6) {
			System.out.println("1 to add");
			System.out.println("2 to update");
			System.out.println("3 to delete");
			System.out.println("4 to read");
			System.out.println("5 to read all");
			System.out.println("6 to return to previous menu");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
					System.out.println("Please enter a number 1 through 6");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a number 1 through 6");
				}
			}
		scan.close();
	}
	
	public void airports() {
		Scanner scan = new Scanner(System.in);
		Integer input = 0;
		while(input != 6) {
			System.out.println("1 to add");
			System.out.println("2 to update");
			System.out.println("3 to delete");
			System.out.println("4 to read");
			System.out.println("5 to read all");
			System.out.println("6 to return to previous menu");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
					System.out.println("Please enter a number 1 through 6");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a number 1 through 6");
				}
			}
		scan.close();
	}
	
	public void travelers() {
		Scanner scan = new Scanner(System.in);
		Integer input = 0;
		while(input != 6) {
			System.out.println("1 to add");
			System.out.println("2 to update");
			System.out.println("3 to delete");
			System.out.println("4 to read");
			System.out.println("5 to read all");
			System.out.println("6 to return to previous menu");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
					System.out.println("Please enter a number 1 through 6");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a number 1 through 6");
				}
			}
		scan.close();
	}
	
	public void employees() {
		Scanner scan = new Scanner(System.in);
		Integer input = 0;
		while(input != 6) {
			System.out.println("1 to add");
			System.out.println("2 to update");
			System.out.println("3 to delete");
			System.out.println("4 to read");
			System.out.println("5 to read all");
			System.out.println("6 to return to previous menu");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
					System.out.println("Please enter a number 1 through 6");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a number 1 through 6");
				}
			}
		scan.close();
	}
	
	

}
