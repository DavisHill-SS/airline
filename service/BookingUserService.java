package service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookingUserDAO;
import entity.BookingUser;

public class BookingUserService{
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<BookingUser> getAll() throws SQLException {
		Connection conn = null;
		List<BookingUser> users = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookingUserDAO udao = new BookingUserDAO(conn);
			users = udao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return users;
	}
	
	public void add(BookingUser user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingUserDAO udao = new BookingUserDAO(conn);
			udao.create(user);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public List<BookingUser> get(BookingUser user) throws SQLException {
		Connection conn = null;
		List<BookingUser> users = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookingUserDAO udao = new BookingUserDAO(conn);
			users = udao.read(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return users;
	}
	
	public void update(BookingUser user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingUserDAO udao = new BookingUserDAO(conn);
			udao.update(user);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void delete(BookingUser user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingUserDAO udao = new BookingUserDAO(conn);
			udao.delete(user);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

}
