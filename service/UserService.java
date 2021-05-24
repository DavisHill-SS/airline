package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import entity.User;

public class UserService {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<User> getAll() throws SQLException {
		Connection conn = null;
		List<User> users = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			users = udao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return users;
	}
	
	public void add(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.create(user);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public List<User> get(User user) throws SQLException {
		Connection conn = null;
		List<User> users = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			users = udao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return users;
	}
	
	public void update(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.update(user);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void delete(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
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
