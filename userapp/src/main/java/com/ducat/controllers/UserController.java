package com.ducat.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ducat.daos.UserDao;
import com.ducat.entities.User;
import com.ducat.validators.MailValidator;

@Controller
@RequestMapping(value="/userapp")
public class UserController {

	@Autowired
	UserDao dao;
	@Autowired
	MailValidator validator;
	
	// Method to return the home page.
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("user", new User());
		return mav;
	}
	
	// Method to register a user.
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView register( 
		 @Valid @ModelAttribute  User user,
		 BindingResult result)
	{
		//custom validation is executed
		validator.validate(user, result);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		
		if(result.hasErrors())
		{
			
			mav.setViewName("index");
			
		} else {
			dao.save(user);
			mav.setViewName("registered");
		}
			return mav;
	}
}
