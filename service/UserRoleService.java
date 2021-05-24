package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserRoleDAO;
import entity.UserRole;

public class UserRoleService{
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<UserRole> getAll() throws SQLException {
		Connection conn = null;
		List<UserRole> roles = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			UserRoleDAO rdao = new UserRoleDAO(conn);
			roles = rdao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return roles;
	}
	
	public void add(UserRole role) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserRoleDAO rdao = new UserRoleDAO(conn);
			rdao.create(role);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public List<UserRole> get(UserRole role) throws SQLException {
		Connection conn = null;
		List<UserRole> roles = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			UserRoleDAO rdao = new UserRoleDAO(conn);
			roles = rdao.read(role);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return roles;
	}
	
	public void update(UserRole role) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserRoleDAO rdao = new UserRoleDAO(conn);
			rdao.update(role);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void delete(UserRole role) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserRoleDAO rdao = new UserRoleDAO(conn);
			rdao.delete(role);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

}
