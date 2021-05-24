package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.BookingUser;

public class BookingUserDAO extends BaseDAO<BookingUser>{
	
	public BookingUserDAO(Connection conn) {
		super(conn);
	}

	public void create(BookingUser user) throws ClassNotFoundException, SQLException {
		save("INSERT into booking_user values (?)",
				new Object[] { user.getUser() });
	}

	public void update(BookingUser user) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_user set user_id = ? where booking_id = ?", new Object[] {
				 user.getUser(), user.getBooking() });
	}

	public void delete(BookingUser user) throws ClassNotFoundException, SQLException {
		save("delete from booking_user where booking_id = ?", new Object[] { user.getBooking() });
	}
	
	public List<BookingUser> read(BookingUser user) throws ClassNotFoundException, SQLException {
		return read("select from booking_user where booking_id = ?", new Object[] { user.getBooking() });
	}

	public List<BookingUser> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from booking_user", null);
	}

	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> users = new ArrayList<>();
		while (rs.next()) {
			BookingUser user = new BookingUser();
			user.getBooking().setId(rs.getInt("booking_id"));
			user.getUser().setId(rs.getInt("user_id"));
			users.add(user);
		}
		return users;
	}
}
