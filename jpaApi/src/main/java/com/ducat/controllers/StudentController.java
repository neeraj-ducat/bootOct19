package com.ducat.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.StudentDao;
import com.ducat.entities.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentDao dao;
	
	@RequestMapping(value="/", method=RequestMethod.GET,
			produces="application/json")
	public Iterable<Student> getAll()
	{
		return dao.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET,
			produces="application/json")
	public Student getById(@PathVariable int id) throws Exception
	{
		Optional<Student> opt = dao.findById(id);
		if (opt.isPresent())
			return opt.get();
		throw(new Exception("Not found."));
	}
	
	@RequestMapping(value="/course/{cname}", method=RequestMethod.GET,
			produces="application/json")
	public Iterable<Student> getByCourse(@PathVariable String cname) throws Exception
	{
		return dao.findByCourse(cname);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST,
			consumes="application/json",
			produces="text/plain")
	public String save(@RequestBody Student s) 
	{
		dao.save(s);
		return "successfully saved.";
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT,
			consumes="application/json",
			produces="text/plain")
	public String update(@RequestBody Student s) 
	{
		dao.save(s);
		return "successfully updated.";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE,
			produces="text/plain")
	public String remove(@PathVariable int id) 
	{
		dao.deleteById(id);
		return "successfully removed.";
	}
}
