package com.ducat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/mvc")
public class Adder {

	// Method to return the home page.
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home()
	{
		return "index";
	}
	
	// Method to return the sum.
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView sum( 
		@RequestParam("num1")  int x, 
		@RequestParam("num2")  int y)
	{
			int z = x + y;
			ModelAndView mav = new ModelAndView();
			mav.addObject("sum", z);
			mav.setViewName("result");
			return mav;
	}
}
