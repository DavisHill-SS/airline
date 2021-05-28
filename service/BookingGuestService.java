package service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookingGuestDAO;
import entity.BookingGuest;

public class BookingGuestService{
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<BookingGuest> getAll() throws SQLException {
		Connection conn = null;
		List<BookingGuest> guests = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookingGuestDAO bdao = new BookingGuestDAO(conn);
			guests = bdao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return guests;
	}
	
	public void add(BookingGuest guest) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingGuestDAO bdao = new BookingGuestDAO(conn);
			bdao.create(guest);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public BookingGuest get(BookingGuest guest) throws SQLException {
		Connection conn = null;
		List<BookingGuest> guests = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookingGuestDAO bdao = new BookingGuestDAO(conn);
			guests = bdao.read(guest);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return guests.get(0);
	}
	
	public void update(BookingGuest guest) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingGuestDAO bdao = new BookingGuestDAO(conn);
			bdao.update(guest);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void delete(BookingGuest guest) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingGuestDAO bdao = new BookingGuestDAO(conn);
			bdao.delete(guest);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

}