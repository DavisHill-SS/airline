package service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.FlightDAO;
import dao.RouteDAO;
import entity.Route;

public class AdminService {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<Route> getAllRoutes() throws SQLException {
		Connection conn = null;
		List<Route> routes = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			routes = rdao.readAll();
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return routes;
	}
	
	public void addFlight(Object [] input) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.create(null);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
}
