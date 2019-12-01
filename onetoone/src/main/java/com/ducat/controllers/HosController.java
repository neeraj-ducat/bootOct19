package com.ducat.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.HeadOfStateDao;
import com.ducat.entities.HeadOfState;

@RestController
@RequestMapping("/hos")
public class HosController {

	@Autowired
	private HeadOfStateDao dao;
	
	@GetMapping("/")
	public Iterable<HeadOfState> getAll() {
		return dao.findAll();
	}
	
	@GetMapping("/{id}")
	public HeadOfState getById(@PathVariable  int id) throws Exception {
		Optional<HeadOfState> opt = dao.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			throw(new Exception("Not found."));
	}
}
