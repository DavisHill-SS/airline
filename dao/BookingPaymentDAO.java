package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.BookingPayment;

public class BookingPaymentDAO extends BaseDAO<BookingPayment>{
	
	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	public void create(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("INSERT into booking_payment values (?, ?)",
				new Object[] { payment.getId(), payment.getRefunded() });
	}

	public void update(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_payment set stripe_id = ?, refunded = ? where id = ?", new Object[] {
				 payment.getId(), payment.getRefunded(), payment.getBooking() });
	}

	public void delete(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("delete from booking_payment where id = ?", new Object[] { payment.getBooking() });
	}
	
	public List<BookingPayment> read(BookingPayment payment) throws ClassNotFoundException, SQLException {
		return read("select from booking_payment where id = ?", new Object[] { payment.getBooking() });
	}

	public List<BookingPayment> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from booking_payment", null);
	}

	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingPayment> payments = new ArrayList<>();
		while (rs.next()) {
			BookingPayment payment = new BookingPayment();
			payment.getBooking().setId(rs.getInt("booking_id"));
			payment.setId(rs.getString("stripe_id"));
			payment.setRefunded(rs.getInt("refunded"));
			payments.add(payment);
		}
		return payments;
	}
}
