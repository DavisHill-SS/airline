package service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AirportDAO;
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
	
	

}
