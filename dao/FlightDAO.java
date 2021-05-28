package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Airplane;
import entity.Flight;
import entity.Route;

public class FlightDAO extends BaseDAO<Flight>{
	
	public FlightDAO(Connection conn) {
		super(conn);
	}

	public void create(Flight flight) throws ClassNotFoundException, SQLException {
		save("INSERT into flight (route_id, airplane_id, departure_time, reserved_seats, seat_price) "
				+ "values (?, ?, ?, ?, ?)",
				new Object[] { flight.getRoute().getId(), flight.getAirplane().getId(), flight.getDepartureTime(),
						flight.getReservedSeats(), flight.getSeatPrice() });
	}

	public void update(Flight flight) throws ClassNotFoundException, SQLException {
		save("UPDATE flight set route_id = ?, airplane_id = ?, departure_time = ?,"
				+ "reserved_seats = ?, seat_price = ? where id = ?", new Object[] {
						flight.getRoute().getId(), flight.getAirplane().getId(), flight.getDepartureTime(),
						flight.getReservedSeats(), flight.getSeatPrice(), flight.getId() });
	}

	public void delete(Flight flight) throws ClassNotFoundException, SQLException {
		save("delete from flight where id = ?", new Object[] { flight.getId() });
	}
	
	public List<Flight> read(Flight flight) throws ClassNotFoundException, SQLException {
		return read("select * from flight where id = ?", new Object[] { flight.getId() });
	}

	public List<Flight> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from flight", null);
	}

	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights  = new ArrayList<>();
		while (rs.next()) {
			Flight flight = new Flight();
			flight.setId(rs.getInt("id"));
			flight.setRoute(new Route());
			flight.getRoute().setId(rs.getInt("route_id"));
			flight.setAirplane(new Airplane());
			flight.getAirplane().setId(rs.getInt("airplane_id"));
			flight.setDepartureTime(rs.getString("departure_time"));
			flight.setReservedSeats(rs.getInt("reserved_seats"));
			flight.setSeatPrice(rs.getFloat("seat_price"));
			flights.add(flight);
		}
		return flights;
	}
}
