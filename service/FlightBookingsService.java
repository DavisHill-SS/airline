package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.FlightBookingsDAO;
import entity.FlightBookings;

public class FlightBookingsService {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<FlightBookings> getAll() throws SQLException {
		Connection conn = null;
		List<FlightBookings> bookings = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			FlightBookingsDAO bdao = new FlightBookingsDAO(conn);
			bookings = bdao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bookings;
	}
	
	public void add(FlightBookings booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightBookingsDAO bdao = new FlightBookingsDAO(conn);
			bdao.create(booking);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public List<FlightBookings> get(FlightBookings booking) throws SQLException {
		Connection conn = null;
		List<FlightBookings> bookings = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			FlightBookingsDAO bdao = new FlightBookingsDAO(conn);
			bookings = bdao.read(booking);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bookings;
	}
	
	public void update(FlightBookings booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightBookingsDAO bdao = new FlightBookingsDAO(conn);
			bdao.update(booking);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void delete(FlightBookings booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightBookingsDAO bdao = new FlightBookingsDAO(conn);
			bdao.delete(booking);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

}
