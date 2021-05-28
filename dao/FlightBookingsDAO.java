package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Booking;
import entity.Flight;
import entity.FlightBookings;

public class FlightBookingsDAO extends BaseDAO<FlightBookings>{
	
	public FlightBookingsDAO(Connection conn) {
		super(conn);
	}

	public void create(FlightBookings booking) throws ClassNotFoundException, SQLException {
		save("INSERT into flight_bookings values (?, ?)",
				new Object[] { booking.getFlight(), booking.getBooking() });
	}

	public void update(FlightBookings booking) throws ClassNotFoundException, SQLException {
		save("UPDATE flight_bookings set flight_id = ? where booking_id = ?", new Object[] {
				 booking.getFlight(), booking.getBooking()});
	}

	public void delete(FlightBookings booking) throws ClassNotFoundException, SQLException {
		save("delete from flight_bookings where booking_id = ?", new Object[] { booking.getBooking() });
	}
	
	public List<FlightBookings> read(FlightBookings booking) throws ClassNotFoundException, SQLException {
		return read("select * from flight_bookings where booking_id = ?", new Object[] {});
	}

	public List<FlightBookings> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from flight_bookings", null);
	}

	@Override
	public List<FlightBookings> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightBookings> bookings = new ArrayList<>();
		while (rs.next()) {
			//Route route = new Route();
			//route.setId(rs.getInt("id"));
			//route.getOriginAirport().setAirportCode(rs.getString("origin_id"));
			//route.getDestAirport().setAirportCode(rs.getString("destination_id"));
			//routes.add(route);
			FlightBookings booking = new FlightBookings();
			booking.setFlight(new Flight());
			booking.getFlight().setId(rs.getInt("flight_id"));
			booking.setBooking(new Booking());
			booking.getBooking().setId(rs.getInt("booking_id"));
			bookings.add(booking);
		}
		return bookings;
	}
}
