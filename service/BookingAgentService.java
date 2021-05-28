package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookingAgentDAO;
import entity.BookingAgent;

public class BookingAgentService{
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<BookingAgent> getAllBookingAgents() throws SQLException {
		Connection conn = null;
		List<BookingAgent> agents = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookingAgentDAO adao = new BookingAgentDAO(conn);
			agents = adao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return agents;
	}
	
	public void addBookingAgent(BookingAgent agent) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingAgentDAO adao = new BookingAgentDAO(conn);
			adao.create(agent);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public BookingAgent getBookingAgent(BookingAgent agent) throws SQLException {
		Connection conn = null;
		List<BookingAgent> agents = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookingAgentDAO adao = new BookingAgentDAO(conn);
			agents = adao.read(agent);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return agents.get(0);
	}
	
	public void updateBookingAgent(BookingAgent agent) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingAgentDAO adao = new BookingAgentDAO(conn);
			adao.update(agent);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void deleteBookingAgent(BookingAgent agent) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingAgentDAO adao = new BookingAgentDAO(conn);
			adao.delete(agent);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

}
