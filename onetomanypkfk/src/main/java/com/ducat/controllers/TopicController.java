package com.ducat.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.TopicDao;
import com.ducat.entities.Topic;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicDao dao;
	
	@GetMapping("/")
	public Iterable<Topic> getAll() {
		return dao.findAll();
	}
	
	@GetMapping("/{id}")
	public Topic getById(@PathVariable  int id) throws Exception {
		Optional<Topic> opt = dao.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			throw(new Exception("Not found."));
	}
}
