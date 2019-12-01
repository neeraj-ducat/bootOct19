package com.ducat.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Course;

@Repository
public interface CourseDao extends CrudRepository<Course, Integer> {

}
