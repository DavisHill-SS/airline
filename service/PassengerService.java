package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PassengerDAO;
import entity.Passenger;

public class PassengerService{
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<Passenger> getAll() throws SQLException {
		Connection conn = null;
		List<Passenger> passengers = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			passengers = pdao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return passengers;
	}
	
	public void add(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.create(passenger);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public Passenger get(Passenger passenger) throws SQLException {
		Connection conn = null;
		List<Passenger> passengers = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			passengers = pdao.read(passenger);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return passengers.get(0);
	}
	
	public void update(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.update(passenger);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void delete(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.delete(passenger);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

}
