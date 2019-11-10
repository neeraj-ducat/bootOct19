package com.ducat.entities;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class User {

	private int id;
	
	@Pattern(regexp="[a-z,A-Z]{2}[a-z,A-Z]*",message="Name can contain alphabets, min length 2")
	private String name;
	@Email(message="MailId should be in proper format.")
	private String mailId;
	@Length(min=4, message="Password length must be at least 4 chars.")
	private String password;
	
	private String roles;
	
	public static final String Role_User = "User";
	public static final String Role_Admin = "Admin";
	
	
	
	public User() {
		super();
		
	}
	
	public User(String name, String mailId, String password, String roles) {
		super();
		this.name = name;
		this.mailId = mailId;
		this.password = password;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
}
