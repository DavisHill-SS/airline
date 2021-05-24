package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.AirplaneType;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType>{
	
	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}

	public void create(AirplaneType type) throws ClassNotFoundException, SQLException {
		save("INSERT into airplane_type values (?)",
				new Object[] { type.getMaxCapacity() });
	}

	public void update(AirplaneType type) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane_type set max_capcity = ? where id = ?", new Object[] { type.getMaxCapacity(), type.getId()
				 });
	}

	public void delete(AirplaneType type) throws ClassNotFoundException, SQLException {
		save("delete from airplane_type where id = ?", new Object[] { type.getId() });
	}
	
	public List<AirplaneType> read(AirplaneType type) throws ClassNotFoundException, SQLException {
		return read("select from where id = ?", new Object[] { type.getId() });
	}

	public List<AirplaneType> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from airplane_type", null);
	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> types = new ArrayList<>();
		while (rs.next()) {
			AirplaneType type = new AirplaneType();
			type.setId(rs.getInt("id"));
			type.setMaxCapacity(rs.getInt("max_capacity"));
			types.add(type);
		}
		return types;
	}
}
