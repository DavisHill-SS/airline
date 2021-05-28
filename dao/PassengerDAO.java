package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Booking;
import entity.Passenger;

public class PassengerDAO extends BaseDAO<Passenger>{
	
	public PassengerDAO(Connection conn) {
		super(conn);
	}

	public void create(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("INSERT into passenger (booking_id, given_name, family_name, dob, gender, address) "
				+ "values (?, ?, ?, ?, ?, ?)",
				new Object[] { passenger.getBooking(), passenger.getGivenName(), passenger.getFamilyName(), 
						passenger.getDob(), passenger.getGender(), passenger.getAddress() });
	}

	public void update(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("UPDATE passenger set booking_id = ?, given_name = ? , family_name = ?, dob = ?, gender = ?,"
				+ " address = ? where id = ?", new Object[] {passenger.getBooking(), passenger.getGivenName(), passenger.getFamilyName(), 
						passenger.getDob(), passenger.getGender(), passenger.getAddress(), passenger.getId() });
	}

	public void delete(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("delete from passenger where id = ?", new Object[] { passenger.getId() });
	}
	
	public List<Passenger> read(Passenger passenger) throws ClassNotFoundException, SQLException {
		return read("select * passenger from where id = ?", new Object[] { passenger.getId() });
	}

	public List<Passenger> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from passenger", null);
	}

	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		while (rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(rs.getInt("id"));
			passenger.setBooking(new Booking());
			passenger.getBooking().setId(rs.getInt("booking_id"));
			passenger.setGivenName(rs.getString("given_name"));
			passenger.setFamilyName(rs.getString("family_name"));
			passenger.setDob(rs.getDate("dob"));
			passenger.setGender(rs.getString("gender"));
			passenger.setAddress(rs.getString("address"));
			passengers.add(passenger);
		}
		return passengers;
	}
}
