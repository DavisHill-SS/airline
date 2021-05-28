package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Booking;
import entity.BookingAgent;
import entity.User;

public class BookingAgentDAO extends BaseDAO<BookingAgent>{
	
	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	public void create(BookingAgent agent) throws ClassNotFoundException, SQLException {
		save("INSERT into booking_agent values (?)",
				new Object[] { agent.getAgent() });
	}

	public void update(BookingAgent agent) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_agent set agent_id where id = ?", new Object[] { agent.getAgent()});
	}

	public void delete(BookingAgent agent) throws ClassNotFoundException, SQLException {
		save("delete booking_agent from where id = ?", new Object[] { agent.getAgent() });
	}
	
	public List<BookingAgent> read(BookingAgent agent) throws ClassNotFoundException, SQLException {
		return read("select * from booking_agent where id = ?", new Object[] { agent.getAgent() });
	}

	public List<BookingAgent> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from booking_agent", null);
	}

	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingAgent> agents = new ArrayList<>();
		while (rs.next()) {
			BookingAgent agent = new BookingAgent();
			agent.setBooking(new Booking());
			agent.getBooking().setId(rs.getInt("booking_id"));
			agent.setAgent(new User());
			agent.getAgent().setId(rs.getInt("agent_id"));
			agents.add(agent);
		}
		return agents;
	}
}
