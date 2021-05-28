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
	
	public Flight() {
		
	}
	
	public Flight(Integer id) {
		this.id = id;
	}
	

	

}
