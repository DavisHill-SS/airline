package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Route;


public class RouteDAO extends BaseDAO<Route> {

	public RouteDAO(Connection conn) {
		super(conn);
	}

	public void create(Route route) throws ClassNotFoundException, SQLException {
		save("INSERT into route (origin_id, destination_id) values (?, ?)",
				new Object[] { route.getOriginAirport().getAirportCode(), route.getDestAirport().getAirportCode() });
	}

	public void update(Route route) throws ClassNotFoundException, SQLException {
		save("UPDATE route set origin_id = ?, destination_id = ? where id = ?", new Object[] {
				route.getOriginAirport().getAirportCode(), route.getDestAirport().getAirportCode(), route.getId() });
	}

	public void delete(Route route) throws ClassNotFoundException, SQLException {
		save("delete from route where id = ?", new Object[] { route.getId() });
	}
	
	public List<Route> read(Route route) throws ClassNotFoundException, SQLException {
		return read("select from route where id = ?", new Object[] {route.getId()});
	}

	public List<Route> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from route", null);
	}
	
	public List<Route> readAllRoutesByAirportCode(String airportCode) throws ClassNotFoundException, SQLException {
		return read("select * from route where origin_id = ? OR destination_id = ?", 
				new Object[] {airportCode, airportCode});
	}

	@Override
	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();
		while (rs.next()) {
			Route route = new Route();
			route.setId(rs.getInt("id"));
			route.getOriginAirport().setAirportCode(rs.getString("origin_id"));
			route.getDestAirport().setAirportCode(rs.getString("destination_id"));
			routes.add(route);
		}
		return routes;
	}

}
