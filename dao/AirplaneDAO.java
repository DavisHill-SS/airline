package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Airplane;
import entity.AirplaneType;

public class AirplaneDAO extends BaseDAO<Airplane>{
	
	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	public void create(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("INSERT into airplane (type_id) values (?)",
				new Object[] { airplane.getAirplaneType()});
	}

	public void update(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane set type_id = ? where id = ?", new Object[] { airplane.getAirplaneType(), airplane.getId() });
	}

	public void delete(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("delete from airplane where id = ?", new Object[] { airplane.getId() });
	}
	
	public List<Airplane> read(Airplane airplane) throws ClassNotFoundException, SQLException {
		return read("select * from where id = ?", new Object[] { airplane.getId() });
	}

	public List<Airplane> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from airplane", null);
	}

	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<>();
		while (rs.next()) {
			Airplane airplane = new Airplane();
			airplane.setId(rs.getInt("id"));
			airplane.setAirplaneType(new AirplaneType());
			airplane.getAirplaneType().setId(rs.getInt("type_id"));
			airplanes.add(airplane);
		}
		return airplanes;
	}
}
