package ui;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import entity.Airport;
import entity.Flight;
import entity.User;
import service.AirportService;
import service.FlightService;
import service.UserService;

public class AdminMenu {
	
	public static void Admin1() {
		Integer input;
		String in;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1) Add/Update/Delete/Read Flights");
			System.out.println("2) Add/Update/Delete/Read Airports");
			System.out.println("3) Add/Update/Delete/Read Users");
			System.out.println("4) To Return to Previous Menu");
			in = scan.next();
			
			try {
				input = Integer.parseInt(in);
				switch(input) {
				case 1:
					FlightsMenu();
					break;
				case 2:
					AirportsMenu();
					break;
				case 3:
					UsersMenu();
					break;
				case 4:
					return;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a valid number");
			}

		}
	}
	
	public static void FlightsMenu() throws SQLException {
		Scanner scan = new Scanner(System.in);
		FlightService fs = new FlightService();
		Integer input;
		Integer id;
		String in;
		
		
		while(true) {
			System.out.println("1) Add Flight");
			System.out.println("2) Update Flight");
			System.out.println("3) Delete Flight");
			System.out.println("4) Read Flight");
			System.out.println("5) Read All Flights");
			System.out.println("6) Return to Previous Menu");
			in = scan.next();
			
			try {
				input = Integer.parseInt(in);
				switch(input) {
				case 1:
					System.out.println("Enter id of flight to add: ");
					id = scan.nextInt();
					fs.addFlight(new Flight(id));
					break;
				case 2:
					System.out.println("Enter id of flight to update: ");
					id = scan.nextInt();
					fs.updateFlight(new Flight(id));
					break;
				case 3:
					System.out.println("Enter id of flight to delete: ");
					id = scan.nextInt();
					fs.deleteFlight(new Flight(id));
					break;
				case 4:
					System.out.println("Enter id of flight to read: ");
					id = scan.nextInt();
					Flight flight = fs.getFlight(new Flight(id));
					System.out.println("Flight Id: " + flight.getId());
					System.out.println("Airplane Type: " + flight.getAirplane().getAirplaneType());
					System.out.println("Reserved Seats: " + flight.getReservedSeats());
					System.out.println("Origin Airport: " + flight.getRoute().getOriginAirport());
					System.out.println("Destination Airport: " + flight.getRoute().getDestAirport());
					System.out.println("Seat Price: " + flight.getSeatPrice());
					System.out.println("Departure Time: " + flight.getDepartureTime());
					break;
				case 5:
					List<Flight> flights = fs.getAllFlights();
					for(Flight f: flights) {
						System.out.println("Flight Id: " + f.getId());
						System.out.println("Airplane Type: " + f.getAirplane().getAirplaneType());
						System.out.println("Reserved Seats: " + f.getReservedSeats());
						System.out.println("Origin Airport: " + f.getRoute().getOriginAirport());
						System.out.println("Destination Airport: " + f.getRoute().getDestAirport());
						System.out.println("Seat Price: " + f.getSeatPrice());
						System.out.println("Departure Time: " + f.getDepartureTime());
						System.out.println("\n=======================\n");
					}
					break;
				case 6:
					return;
				default:
					System.out.println("Please enter a valid number");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a valid number");
			}

		}
		
	}
	
	public static void AirportsMenu(){
		Scanner scan = new Scanner(System.in);
		AirportService as = new AirportService();
		Integer input;
		String in;
		
		while(true) {
			System.out.println("1) Add Airport");
			System.out.println("2) Update Airport");
			System.out.println("3) Delete Airport");
			System.out.println("4) Read Airport");
			System.out.println("5) Read All Airports");
			System.out.println("6) Return to Previous Menu");
			in = scan.next();
			
			try {
				input = Integer.parseInt(in);
				switch(input) {
				case 1:
					as.addAirport(new Airport());
					break;
				case 2:
					System.out.println("Enter iata_id of airport to update: ");
					in = scan.next();
					as.updateAirport(new Airport(in));
					break;
				case 3:
					System.out.println("Enter iata_id of airport to delete: ");
					in = scan.next();
					as.deleteAirport(new Airport(in));
					break;
				case 4:
					System.out.println("Enter iata_id of user to read");
					in = scan.next();
					Airport airport = as.getAirport(new Airport(in));
					System.out.println("Airport Code: " + airport.getAirportCode());
					System.out.println("Airport City: " + airport.getCityName());
					break;
				case 5:
					List<Airport> airports = as.getAllAirports();
					for(Airport a: airports) {
						System.out.println("Airport Code: " + a.getAirportCode());
						System.out.println("Airport City: " + a.getCityName());
						System.out.println("\n=======================\n");
					}
					break;
				case 6:
					return;
				default:
					System.out.println("Please enter 1, 2, 3, or 4");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter 1, 2, or 3");
			}

		}
		
	}
	
	public static void UsersMenu(){
		UserService us = new UserService();
		Scanner scan = new Scanner(System.in);
		Integer input;
		String in;
		
		while(true) {
			System.out.println("1) Add Users");
			System.out.println("2) Update Users");
			System.out.println("3) Delete Users");
			System.out.println("4) Read User");
			System.out.println("5) Read All Users");
			System.out.println("6) Return to Previous Menu");
			in = scan.next();
			
			try {
				input = Integer.parseInt(in);
				switch(input) {
				case 1:
					us.add(new User());
					break;
				case 2:
					System.out.println("Enter id of user to update: ");
					input = scan.nextInt();
					us.update(new User(input));
					break;
				case 3:
					System.out.println("Enter id of user to delete");
					input = scan.nextInt();
					us.delete(new User(input));
					break;
				case 4:
					System.out.println("Enter id of user to read");
					input = scan.nextInt();
					User u = us.get(new User(input));
					System.out.println("Id: " + u.getId());
					System.out.println("Role: " + u.getRole());
					System.out.println("Email: " + u.getEmail());
					System.out.println("Family Name: " + u.getFamilyName());
					System.out.println("Given Name: " + u.getGivenName());
					System.out.println("Password: " + u.getPassword());
					System.out.println("Phone: " + u.getPhone());
					System.out.println("Username : " + u.getUsername());
					break;
				case 5:
					List<User> users = us.getAll();
					for(User user: users) {
						System.out.println("Id: " + user.getId());
						System.out.println("Role: " + user.getRole().getId());
						System.out.println("Email: " + user.getEmail());
						System.out.println("Family Name: " + user.getFamilyName());
						System.out.println("Given Name: " + user.getGivenName());
						System.out.println("Password: " + user.getPassword());
						System.out.println("Phone: " + user.getPhone());
						System.out.println("Username : " + user.getUsername());
						System.out.println("\n =================================== \n");
					}
					break;
				case 6:
					return;
				default:
					System.out.println("Please enter a valid number");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a valid number");
			}

		}
		
	}
	
}
