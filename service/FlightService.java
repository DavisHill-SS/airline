package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.FlightDAO;
import entity.Flight;

public class FlightService {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<Flight> getAllFlights() throws SQLException {
		Connection conn = null;
		List<Flight> flights = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			flights = fdao.readAll();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return flights;
	}
	
	public void addFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.create(flight);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public Flight getFlight(Flight flight) throws SQLException {
		Connection conn = null;
		List<Flight> flights = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			flights = fdao.read(flight);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return flights.get(0);
	}
	
	public void updateFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.update(flight);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void deleteFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.delete(flight);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

}
