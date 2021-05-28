package ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Airport;
import entity.Flight;
import entity.Route;
import service.AirportService;
import service.FlightService;
import service.RouteService;

public class EmployeeMenu {
	static FlightService fs = new FlightService();
	static RouteService rs = new RouteService();
	static AirportService as = new AirportService();
	
	public static void Emp1() {
		Integer input;
		String in;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1) List Flights");
			System.out.println("2) Return to Previous Menu");
			in = scan.next();
			
			try {
				input = Integer.parseInt(in);
				switch(input) {
				case 1:
					Emp2();
					break;
				case 2:
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
	
	//System.out.println("Enter your user_id");
	public static void Emp2() throws SQLException {

		
		List<Flight> flights = fs.getAllFlights();
		
		Route route;
		Airport origin;
		Airport dest;
		Integer count = 1;
		Integer input;
		
		Scanner scan = new Scanner(System.in);
		StringBuilder s = new StringBuilder();
		
		System.out.println("Enter the number of the flight you want to manage");
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
		System.out.println(count + ") Return to Previous Menu");
		input = scan.nextInt();
		if (input == count) {
			return;
		}
		else {
			Emp3(flights.get(input-1));
		}
	}
	
	public static void Emp3(Flight flight) throws SQLException {
		Scanner scan = new Scanner(System.in);
		Integer id = flight.getId();
		Integer input;
		String in;

		while(true) {
			System.out.println("1) View Details of Flight " + id);
			System.out.println("2) Update Flight " + id);
			System.out.println("3) Add Seats to Flight " + id);
			System.out.println("4) Return to Previous Menu ");
			in = scan.next();
			try {
				input = Integer.parseInt(in);
				switch(input) {
				case 1:{
					ViewFlight(flight);
					break;
				}
				case 2:{
					UpdateFlight(flight);
					break;
				}
				case 3:{
					AddSeats(flight);
					break;
				}
				case 4:{
					return;
					}
				}
			}
			catch(Exception e) {
				System.out.println("Please enter a valid number");
				}	
			}
		}
	
	public static void ViewFlight(Flight flight) throws SQLException {
		Scanner scan = new Scanner(System.in);
		Route route = rs.getRoute(new Route(flight.getRoute().getId()));
		Airport origin = as.getAirport(route.getOriginAirport());
		Airport dest = as.getAirport(route.getDestAirport());
		StringBuilder s = new StringBuilder();
		String[] dateTime;
		
		s.append("You have chosen to view the Flight with Flight Id: ").append(flight.getId());
		s.append(" and Departure Airport: ").append(origin.getAirportCode()).append(" and Arrival Airport : ").append(dest.getAirportCode());
		System.out.println(s.toString());
		System.out.println(" \n");
		
		dateTime = flight.getDepartureTime().split(" ");
		String date = dateTime[0];
		String time = dateTime[1];
		
		s.setLength(0);
		s.append("Departure Airport: ").append(origin.getAirportCode()).append(" | ").append("Arrival Airport: ").append(dest.getAirportCode()).append(" | \n");
		s.append("Departure Date: ").append(date).append(" | ").append("Departure Time: ").append(time).append(" | \n");
		System.out.println(s.toString());
		s.setLength(0);
		
		System.out.println("Seats: ");
		System.out.println(flight.getReservedSeats());
		
		System.out.println("1) Return to Previous Menu ");
		Integer input = scan.nextInt();
		if(input == 1) {
			return;
		}
		
		
		
	}
	public static void UpdateFlight(Flight flight) throws SQLException {
		Scanner scan = new Scanner(System.in);
		Route route = rs.getRoute(new Route(flight.getRoute().getId()));
		Airport origin = as.getAirport(route.getOriginAirport());
		Airport dest = as.getAirport(route.getDestAirport());
		StringBuilder s = new StringBuilder();
		String in;
		
		s.append("You have chosen to update the Flight with Flight Id: ").append(flight.getId());
		s.append(" and Departure Airport: ").append(origin.getAirportCode()).append(" and Arrival Airport : ").append(dest.getAirportCode());
		System.out.println(s.toString());
		
		List<Object> list = new ArrayList<>();
		System.out.println("Enter 'quit' at any time to cancel operation");
		System.out.println("Please enter new Origin Airport and City or enter N/A for no change: ");
		
		in = scan.next();
		Route new_route = new Route();
		if(in.equals("quit")) {
			return;
		}
		else if(in.equals("N/A")){
		}
		else {
			Airport airport_origin = new Airport();
			airport_origin.setAirportCode(in);
			new_route.setOriginAirport(airport_origin);
			//flight.setRoute(new_route);
		}
		
		System.out.println("Please enter new Destination Airport and City or enter N/A for no change: ");
		in = scan.next();
		if(in.equals("quit")) {
			return;
		}
		else if(in.equals("N/A")){
		}
		else {
			Airport airport_dest = new Airport();
			airport_dest.setAirportCode(in);
			new_route.setDestAirport(airport_dest);
			//flight.setRoute(new_route);
		}
		
		System.out.println("Please enter new Departure Date or enter N/A for no change: ");
		in = scan.next();
		if(in.equals("quit")) {
			return;
		}
		else if(in.equals("N/A")){
		}
		else {
			
		}
		
		System.out.println("Please enter new Departure Time or enter N/A for no change: ");
		in = scan.next();
		if(in.equals("quit")) {
			return;
		}
		else if(in.equals("N/A")){
		}
		else {
			
		}
		
		fs.updateFlight(flight);
		return;
		
	}
	public static void AddSeats(Flight flight) throws SQLException {
		Scanner scan = new Scanner(System.in);
		Integer input;
		System.out.println("Enter how many seats you want to add to flight: " + flight.getId());
		input = scan.nextInt();
		flight.setReservedSeats(flight.getReservedSeats() + input);
		fs.updateFlight(flight);
		return;
		
		
	}
}
