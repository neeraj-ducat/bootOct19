package com.ducat.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ducat.entities.User;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate template;
	
	private static final String Save_Query = "insert into UsersMaster (name, mailId, password, roles) values (?,?,?,?)";
	
	public void save(User user) {
		template.update(Save_Query, user.getName(), user.getMailId(),user.getPassword(), User.Role_User);
	}
}
