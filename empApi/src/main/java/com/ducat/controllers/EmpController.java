package com.ducat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.EmpDao;
import com.ducat.entities.Emp;

@RestController
@RequestMapping("/emps")
public class EmpController {

	@Autowired
	EmpDao dao;
	
	// to return all employees.
	@RequestMapping(value="/", method=RequestMethod.GET,
			produces="application/json")
	public List<Emp> getAllEmp()
	{
		return dao.getAll();
	}
	
	// to save an employee
	@RequestMapping(value="/", method=RequestMethod.POST,
			consumes="application/json",
			produces="text/plain")
	public String saveEmp(@RequestBody Emp e)
	{
		dao.save(e);
		return "successfully saved.";
	}
	
	// to update an employee
	@RequestMapping(value="/", method=RequestMethod.PUT,
			consumes="application/json",
			produces="text/plain")
	public String updateEmp(@RequestBody Emp e)
	{
		dao.update(e);
		return "successfully updated.";
	}
	
	// to delete an employee
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE,
			produces="text/plain")
	public String updateEmp(@PathVariable int id)
	{
		dao.remove(id);
		return "successfully removed.";
	}
}
