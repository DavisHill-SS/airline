package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AirplaneDAO;
import entity.Airplane;

public class AirplaneService{
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<Airplane> getAllAirplanes() throws SQLException {
		Connection conn = null;
		List<Airplane> airplanes = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			AirplaneDAO adao = new AirplaneDAO(conn);
			airplanes = adao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return airplanes;
	}
	
	public void addAirplane(Airplane airplane) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO adao = new AirplaneDAO(conn);
			adao.create(airplane);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public Airplane getAirplane(Airplane airplane) throws SQLException {
		Connection conn = null;
		List<Airplane> airplanes = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			AirplaneDAO adao = new AirplaneDAO(conn);
			airplanes = adao.read(airplane);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return airplanes.get(0);
	}
	
	public void updateAirplane(Airplane airplane) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO adao = new AirplaneDAO(conn);
			adao.update(airplane);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void deleteAirplane(Airplane airplane) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO adao = new AirplaneDAO(conn);
			adao.delete(airplane);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

}
