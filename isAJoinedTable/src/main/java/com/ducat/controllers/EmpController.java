package com.ducat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.EmpDao;
import com.ducat.entities.Emp;


@RestController
@RequestMapping("/emps")
public class EmpController {

	@Autowired
	private EmpDao dao;
	
	@PostMapping(value="/")
	public String save(@RequestBody Emp e) {
		dao.save(e);
		return "success";
	}
	
	@GetMapping(value="/")
	public Iterable<Emp> fetch() {
		return dao.findAll();
	}
}
