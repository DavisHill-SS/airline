package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookingDAO;
import entity.Booking;

public class BookingService{
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<Booking> getAll() throws SQLException {
		Connection conn = null;
		List<Booking> bookings = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			bookings = bdao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bookings;
	}
	
	public void add(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			bdao.create(booking);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public Booking get(Booking booking) throws SQLException {
		Connection conn = null;
		List<Booking> bookings = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			bookings = bdao.read(booking);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bookings.get(0);
	}
	
	public void update(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			bdao.update(booking);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void delete(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
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
