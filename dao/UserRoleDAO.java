package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.UserRole;

public class UserRoleDAO extends BaseDAO<UserRole>{
	
	public UserRoleDAO(Connection conn) {
		super(conn);
	}

	public void create(UserRole role) throws ClassNotFoundException, SQLException {
		save("INSERT into values (?)",
				new Object[] { role.getName() });
	}

	public void update(UserRole role) throws ClassNotFoundException, SQLException {
		save("UPDATE user_role set name = ? where id = ?", new Object[] { role.getName(), role.getId() });
	}

	public void delete(UserRole role) throws ClassNotFoundException, SQLException {
		save("delete from user_role where id = ?", new Object[] { role.getId() });
	}
	
	public List<UserRole> read(UserRole role) throws ClassNotFoundException, SQLException {
		return read("select * from user_role where id = ?", new Object[] { role.getId() });
	}

	public List<UserRole> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from user_role", null);
	}

	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> roles = new ArrayList<>();
		while (rs.next()) {
			UserRole role = new UserRole();
			role.setId(rs.getInt("id"));
			role.setName(rs.getString("name"));
			roles.add(role);
		}
		return roles;
	}
}