package ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Airport;
import entity.BookingUser;
import entity.Flight;
import entity.Route;
import entity.User;
import service.AirportService;
import service.BookingUserService;
import service.FlightService;
import service.RouteService;
import service.UserService;

public class TravelerMenu {
	
	static BookingUserService bus = new BookingUserService();
	static UserService us = new UserService();
	static FlightService fs = new FlightService();
	static AirportService as = new AirportService();
	static RouteService rs = new RouteService();
	static Integer id;
	
	public static void TravAuth() throws SQLException {
		Integer input;
		String in;
		Scanner scan = new Scanner(System.in);
		
		//List<BookingUser> users = bus.getAll();
		
		List<User> travelers = us.getAllTravelers();
		List<Integer> traveler_ids = new ArrayList<>();
		for(User traveler: travelers) {
			traveler_ids.add(traveler.getId());
		}
		
		while(true) {
			System.out.println("Enter a valid user number or enter 0 to return to previous menu");
			in = scan.next();
			
			try {
				input = Integer.parseInt(in);
				switch(input) {
				case 0:
					return;
				default:
					if (traveler_ids.contains(input)) {
						id = input;
						Trav1();
						}
					}
				}catch(Exception e) {
					System.out.println("Please enter a valid user id");
				}
		}
	}
	
	public static void Trav1(){
		Integer input;
		String in;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1) Book a Ticket");
			System.out.println("2) Cancel an Upcoming Trip");
			System.out.println("3) Quit to Previous");
			in = scan.next();
			
			try {
				input = Integer.parseInt(in);
				switch(input) {
				case 1:
					ViewFlights();
					break;
				case 2:
					CancelTrip();
					break;
				case 3:
					return;
				default:
					System.out.println("Please enter 1, 2, or 3");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter 1, 2, or 3");
			}

		}
		
	}
	
	public static void ViewFlights() throws SQLException {
		List<Flight> flights = fs.getAllFlights();
		Scanner scan = new Scanner(System.in);
		Integer input;
		Route route;
		Airport origin;
		Airport dest;
		Integer count = 1;
		StringBuilder s = new StringBuilder();
		System.out.println("Pick the Flight you want to book a ticket for: ");
		
		for(Flight flight: flights) {
			route = rs.getRoute(new Route(flight.getRoute().getId()));
			origin = as.getAirport(route.getOriginAirport());
			dest = as.getAirport(route.getDestAirport());
			
			s.append(count).append(") ").append(origin.getAirportCode()).append(", ").append(origin.getCityName()).append(" -> ")
			.append(dest.getAirportCode()).append(", ").append(dest.getCityName());
			
			System.out.println(s.toString());
			s.setLength(0);
			count += 1;
		}
		
		System.out.println(count + ") Quit to Previous");
		input = scan.nextInt();
		if (input == count) {
			return;
		}
		else {
			BookTicket(flights.get(input-1));
			
		}
		
	}
	
	public static void BookTicket(Flight flight) {
		Scanner scan = new Scanner(System.in);
		Integer input;
		String in;
		
		while(true) {
			System.out.println("1) View Flight Details");
			System.out.println("2) Book a Ticket");
			System.out.println("3) Return to Previous Menu");
			in = scan.next();
			try {
				input = Integer.parseInt(in);
				switch(input) {
				case 1:
					EmployeeMenu.ViewFlight(flight);
				case 2:
					flight.setReservedSeats(flight.getReservedSeats() + 1);
					fs.updateFlight(flight);
				case 3:
					return;
				}
			}catch(Exception e) {
				System.out.println("Please enter a valid option");
			}

			
		}

		
	}
	
	public static void CancelTrip() {
		
	}

}
 