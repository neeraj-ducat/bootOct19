package com.ducat.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Emp;

@Repository
public class EmpDao {

	@Autowired
	JdbcTemplate template;
	
	private static final String Save_Query ="insert into Emp (name,job,salary) values (?,?,?)";
	private static final String Update_Query ="update Emp set name=?, job=?, salary=? where id=?";
	private static final String Delete_Query ="delete from Emp where id=?";
	private static final String Fetach_All_Query ="select * from Emp";
	private static final String Fetch_By_Id_Query ="select * from Emp where id=?";
	
	private RowMapper<Emp> mapper = new RowMapper<Emp>() {
		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			Emp emp = new Emp();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setSalary(rs.getInt(4));
			return emp;
		}
	};
	
	
	public void save(Emp e) {
		template.update(Save_Query, e.getName(), e.getJob(),e.getSalary());
	}
	
	public void update(Emp e) {
		template.update(Update_Query, e.getName(), e.getJob(),e.getSalary(), e.getId());
	}
	public void remove(int id) {
		template.update(Delete_Query, new Integer[] {id});
	}
	
	public List<Emp> getAll()
	{
		return template.query(Fetach_All_Query, new Object[] {}, mapper);
	}
}
