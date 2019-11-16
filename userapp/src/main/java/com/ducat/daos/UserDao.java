package com.ducat.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ducat.entities.User;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate template;
	
	private static final String Save_Query = "insert into UsersMaster (name, mailId, password, roles) values (?,?,?,?)";
	private static final String Fetch_Query = "select * from UsersMaster where mailId = ?";
	
	public void save(User user) {
		template.update(Save_Query, user.getName(), user.getMailId(),user.getPassword(), User.Role_User);
	}
	
	public boolean isFound(String mailId) {
		List<User> list = template.query(Fetch_Query, new String[] {mailId}, rowMapper);
		if(list.isEmpty())
			return false;
		else
			return true;
	}
	
	RowMapper<User> rowMapper =  new RowMapper<User>() {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setMailId(rs.getString(3));
			user.setPassword(rs.getString(4));
			user.setRoles(rs.getString(5));
			return user;
		}
		
	};
}
