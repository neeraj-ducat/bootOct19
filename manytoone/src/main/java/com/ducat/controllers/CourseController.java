package com.ducat.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.CourseDao;
import com.ducat.dtos.CourseDto;
import com.ducat.entities.Course;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseDao dao;
	
	@PostMapping("/")
	public String save(@RequestBody Course course) {
		dao.save(course);
		return "successfully saved.";
	}
	
	@GetMapping("/")
	public List<CourseDto> getAll() {
		List<Course> list = Lists.newArrayList(dao.findAll());
		return list.stream()
				.map(course -> toDto(course))
				.collect(Collectors.toList());
	}
	
	public CourseDto toDto(Course course)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(course, CourseDto.class);
	}
	@GetMapping("/{id}")
	public Course getById(@PathVariable  int id) throws Exception {
		Optional<Course> opt = dao.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			throw(new Exception("Not found."));
	}
}
