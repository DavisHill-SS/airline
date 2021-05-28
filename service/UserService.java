package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.UserDAO;
import entity.User;
import entity.UserRole;

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
	
	public List<User> getAllTravelers() throws SQLException {
		Connection conn = null;
		List<User> users = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			users = udao.readAllTravelers();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return users;
	}
	
	public void add(User user) throws SQLException {
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		//User user = new User();
		String in;
		Integer input;
		
		System.out.println("Enter User Role: ");
		input = scan.nextInt();
		user.setRole(new UserRole(input));
		
		System.out.println("Enter Given Name: ");
		in = scan.next();
		user.setGivenName(in);
		
		System.out.println("Enter Family Name: ");
		in = scan.next();
		user.setFamilyName(in);
		
		System.out.println("Enter Username: ");
		in = scan.next();
		user.setUsername(in);
		
		System.out.println("Enter User Email: ");
		in = scan.next();
		user.setEmail(in);
		
		System.out.println("Enter User Password: ");
		in = scan.next();
		user.setPassword(in);
		
		System.out.println("Enter User Phone: ");
		in = scan.next();
		user.setPhone(in);
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
	
	public User get(User user) throws SQLException {
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
		return users.get(0);
	}
	
	public void update(User user) throws SQLException {
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		String in;
		Integer input;
		
		System.out.println("Enter User Role: ");
		input = scan.nextInt();
		user.setRole(new UserRole(input));
		
		System.out.println("Enter Given Name: ");
		in = scan.next();
		user.setGivenName(in);
		
		System.out.println("Enter Family Name: ");
		in = scan.next();
		user.setFamilyName(in);
		
		System.out.println("Enter Username: ");
		in = scan.next();
		user.setUsername(in);
		
		System.out.println("Enter User Email: ");
		in = scan.next();
		user.setEmail(in);
		
		System.out.println("Enter User Password: ");
		in = scan.next();
		user.setPassword(in);
		
		System.out.println("Enter User Phone: ");
		in = scan.next();
		user.setPhone(in);
		
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
