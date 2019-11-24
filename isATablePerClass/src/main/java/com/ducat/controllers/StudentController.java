package com.ducat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.StudentDao;
import com.ducat.entities.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentDao dao;
	
	@PostMapping(value="/")
	public String save(@RequestBody Student s) {
		dao.save(s);
		return "success";
	}
	
	@GetMapping(value="/")
	public Iterable<Student> fetch() {
		return dao.findAll();
	}
}
