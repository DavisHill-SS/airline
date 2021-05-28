package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import entity.UserRole;

public class UserDAO extends BaseDAO<User>{
	
	public UserDAO(Connection conn) {
		super(conn);
	}

	public void create(User user) throws ClassNotFoundException, SQLException {
		save("INSERT into user (role_id, given_name, family_name, username, email, password, phone) "
				+ "values (?, ?, ?, ?, ?, ?)",
				new Object[] { user.getRole(), user.getGivenName(), user.getFamilyName(), user.getUsername(), user.getEmail(),
						user.getPassword(), user.getPhone() });
	}

	public void update(User user) throws ClassNotFoundException, SQLException {
		save("UPDATE user set role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ? where id = ?", new Object[] { 
				user.getRole(), user.getGivenName(), user.getFamilyName(), user.getUsername(), user.getEmail(),
				user.getPassword(), user.getPhone(), user.getId() });
	}

	public void delete(User user) throws ClassNotFoundException, SQLException {
		save("delete from where id = ?", new Object[] { user.getId() });
	}
	
	public List<User> read(User user) throws ClassNotFoundException, SQLException {
		return read("select * from user where id = ?", new Object[] { user.getId() });
	}

	public List<User> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from user", null);
	}
	
	public List<User> readAllTravelers() throws ClassNotFoundException, SQLException {
		return read("select * from user where role_id = 3", null);
	}

	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setRole(new UserRole());
			user.getRole().setId(rs.getInt("role_id"));
			user.setGivenName(rs.getString("given_name"));
			user.setFamilyName(rs.getString("family_name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			users.add(user);
			
		}
		return users;
	}
}
