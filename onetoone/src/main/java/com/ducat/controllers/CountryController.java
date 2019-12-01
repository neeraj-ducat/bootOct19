package com.ducat.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.CountryDao;
import com.ducat.entities.Country;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryDao dao;
	
	@PostMapping("/")
	public String save(@RequestBody Country country) {
		dao.save(country);
		return "successfully saved.";
	}
	
	@GetMapping("/")
	public Iterable<Country> getAll() {
		return dao.findAll();
	}
	
	@GetMapping("/{id}")
	public Country getById(@PathVariable  int id) throws Exception {
		Optional<Country> opt = dao.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			throw(new Exception("Not found."));
	}
}
