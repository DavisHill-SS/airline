package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Booking;

public class BookingDAO extends BaseDAO<Booking>{
	
	public BookingDAO(Connection conn) {
		super(conn);
	}

	public void create(Booking booking) throws ClassNotFoundException, SQLException {
		save("INSERT into booking values (?, ?)",
				new Object[] { booking.getIsActive(), booking.getConfirmationCode() });
	}

	public void update(Booking booking) throws ClassNotFoundException, SQLException {
		save("UPDATE booking set is_active = ?, confirmation_code = ? where id = ?", new Object[] {
				 booking.getIsActive(), booking.getConfirmationCode(), booking.getId() });
	}

	public void delete(Booking booking) throws ClassNotFoundException, SQLException {
		save("delete from booking where id = ?", new Object[] { booking.getId() });
	}
	
	public List<Booking> read(Booking booking) throws ClassNotFoundException, SQLException {
		return read("select * from booking where id = ?", new Object[] { booking.getId() });
	}

	public List<Booking> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from booking", null);
	}

	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> bookings = new ArrayList<>();
		while (rs.next()) {
			Booking booking = new Booking();
			booking.setId(rs.getInt("id"));
			booking.setIsActive(rs.getInt("is_active"));
			booking.setConfirmationCode(rs.getString("confirmation_code"));
			bookings.add(booking);
		}
		return bookings;
	}
}
