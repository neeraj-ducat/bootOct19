package com.ducat.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ducat.daos.UserDao;
import com.ducat.entities.User;

@Component
public class MailValidator implements Validator{

	@Autowired
	UserDao dao;
	
	public boolean supports(Class<?> cl) {
		return cl.equals(User.class);
	}

	public void validate(Object target, Errors errors) {
		User user=(User)target;
		
		if(dao.isFound(user.getMailId()))
		{
			//mailId already exists, fail the validation
			errors.rejectValue("mailId", "mailId", "Already registered.");
		}
		
	}

}
