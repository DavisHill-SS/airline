package entity;

import java.util.Scanner;

public class Airport {
	
	private String airportCode;
	private String cityName;
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public Airport() {
		
	}
	
	public Airport(String iata_id) {
		this.airportCode = iata_id;
	}

}
