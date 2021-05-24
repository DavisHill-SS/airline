package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest>{
	
	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	public void create(BookingGuest guest) throws ClassNotFoundException, SQLException {
		save("INSERT into booking_guest values (?, ?)",
				new Object[] { guest.getContactEmail(), guest.getContactPhone() });
	}

	public void update(BookingGuest guest) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_guest set contact_email = ?, contact_phone = ? where id = ?", new Object[] {
				 guest.getContactEmail(), guest.getContactPhone(), guest.getBooking() });
	}

	public void delete(BookingGuest guest) throws ClassNotFoundException, SQLException {
		save("delete from booking_guest where id = ?", new Object[] { guest.getBooking() });
	}
	
	public List<BookingGuest> read(BookingGuest guest) throws ClassNotFoundException, SQLException {
		return read("select from where id = ?", new Object[] { guest.getBooking() });
	}

	public List<BookingGuest> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from booking_guest", null);
	}

	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> guests = new ArrayList<>();
		while (rs.next()) {
			BookingGuest guest = new BookingGuest();
			guest.getBooking().setId(rs.getInt("booking_id"));
			guest.setContactEmail(rs.getString("contact_email"));
			guest.setContactPhone(rs.getString("contact_phone"));
			guests.add(guest);
		}
		return guests;
	}
}
