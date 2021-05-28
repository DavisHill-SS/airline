package service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.AirplaneDAO;
import dao.AirportDAO;
import entity.Airplane;
import entity.Airport;

public class AirportService {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<Airport> getAllAirports() throws SQLException {
		Connection conn = null;
		List<Airport> airports = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			airports = adao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return airports;
	}
	
	public void addAirport(Airport airport) throws SQLException{
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		String in;
		
		System.out.println("Enter Airport Code: ");
		in = scan.next();
		airport.setAirportCode(in);
		
		System.out.println("Enter Airport City: ");
		in = scan.next();
		airport.setCityName(in);
		
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			adao.create(airport);
			conn.commit();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public Airport getAirport(Airport airport) throws SQLException {
		Connection conn = null;
		List<Airport> airports = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			airports = adao.read(airport);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return airports.get(0);
	}
	
	public void updateAirport(Airport airport) throws SQLException {
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		String in;
		
		System.out.println("Enter Airport City: ");
		in = scan.next();
		airport.setCityName(in);
		
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			adao.update(airport);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void deleteAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			adao.delete(airport);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	

}
