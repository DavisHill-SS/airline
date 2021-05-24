package entity;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import service.AirplaneService;
import service.RouteService;

public class Flight {
	private Integer id;
	private Route route;
	private Airplane airplane;
	private String departureTime;
	private Integer reservedSeats;
	private Float seatPrice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Airplane getAirplane() {
		return airplane;
	}
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public Integer getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public Float getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	
	public Flight (Integer id){
		Scanner scan = new Scanner(System.in);
		//Flight flight = new Flight();
		//String[] list = {"route","airplane","departure time",
		//	"reserved seats", "seat price"};
		System.out.println("Available routes...");
		RouteService rs = new RouteService();
		List<Route> routes;
		
		try {
			routes = rs.getAllRoutes();
			for(Route route: routes){
				System.out.println(route);
			}
			System.out.print("Select a route by id: ");
			Integer route_id = scan.nextInt();
			Route route = routes.get(route_id);
			this.setRoute(route);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("Available airplanes...");
		AirplaneService as = new AirplaneService();
		List<Airplane> airplanes;
		try {
			airplanes = as.getAllAirplanes();
			for(Airplane airplane: airplanes) {
				System.out.println(airplane);
			}
			System.out.print("Select an airplane by id: ");
			Integer airplane_id = scan.nextInt();
			Airplane airplane = airplanes.get(airplane_id);
			this.setAirplane(airplane);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		System.out.println("Enter departure date in form YYYY-mm-dd");
		String date = scan.next();
		System.out.println("Enter departure time in form HH:MM");
		String time = scan.next();
		String datetime = date + "T" + time;
		this.setDepartureTime(datetime);
		
		System.out.println("Enter number of seats");
		Integer seats = scan.nextInt();
		this.setReservedSeats(seats);
		
		System.out.println("Enter seat price");
		Float price = scan.nextFloat();
		this.setSeatPrice(price);
		scan.close();
		
	}
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	

}
