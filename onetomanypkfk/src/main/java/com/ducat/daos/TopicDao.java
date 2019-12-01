package com.ducat.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Topic;

@Repository
public interface TopicDao extends 
	CrudRepository<Topic, Integer> {

}
