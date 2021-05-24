package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.RouteDAO;
import entity.Route;

public class RouteService{
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<Route> getAllRoutes() throws SQLException {
		Connection conn = null;
		List<Route> routes = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			routes = rdao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return routes;
	}
	
	public void addRoute(Route route) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			rdao.create(route);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public List<Route> getRoute(Route route) throws SQLException {
		Connection conn = null;
		List<Route> routes = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			routes = rdao.read(route);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return routes;
	}
	
	public void updateRoute(Route route) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			rdao.update(route);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void deleteRoute(Route route) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			rdao.delete(route);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

}
