package service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AirplaneTypeDAO;
import entity.AirplaneType;

public class AirplaneTypeService{
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<AirplaneType> getAllAirplaneTypes() throws SQLException {
		Connection conn = null;
		List<AirplaneType> types = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO tdao = new AirplaneTypeDAO(conn);
			types = tdao.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return types;
	}
	
	public void addAirplaneType(AirplaneType type) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO tdao = new AirplaneTypeDAO(conn);
			tdao.create(type);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public AirplaneType getAirplaneType(AirplaneType type) throws SQLException {
		Connection conn = null;
		List<AirplaneType> types = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO tdao = new AirplaneTypeDAO(conn);
			types = tdao.read(type);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return types.get(0);
	}
	
	public void updateAirplaneType(AirplaneType type) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO tdao = new AirplaneTypeDAO(conn);
			tdao.update(type);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public void deleteAirplaneType(AirplaneType type) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO tdao = new AirplaneTypeDAO(conn);
			tdao.delete(type);
			conn.commit(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

}