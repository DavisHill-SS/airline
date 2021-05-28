package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Airport;

public class AirportDAO extends BaseDAO<Airport> {
	
	public AirportDAO(Connection conn) {
		super(conn);
	}

	public void create(Airport airport) throws ClassNotFoundException, SQLException {
		save("INSERT into airport values (?, ?)",
				new Object[] { airport.getAirportCode(), airport.getCityName() });
	}

	public void update(Airport airport) throws ClassNotFoundException, SQLException {
		save("UPDATE airport set city = ? where iata_id = ?", new Object[] { airport.getCityName(),
				airport.getAirportCode() });
	}

	public void delete(Airport airport) throws ClassNotFoundException, SQLException {
		save("delete from airport where iata_id = ?", new Object[] { airport.getAirportCode() });
	}
	
	public List<Airport> read(Airport airport) throws ClassNotFoundException, SQLException {
		return read("select * from airport where iata_id = ?", new Object[] { airport.getAirportCode() });
	}

	public List<Airport> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from airport", null);
	}

	@Override
	public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		while (rs.next()) {
			Airport airport = new Airport();
			airport.setAirportCode(rs.getString("iata_id"));
			airport.setCityName(rs.getString("city"));
			airports.add(airport);
		}
		return airports;
	}
}
