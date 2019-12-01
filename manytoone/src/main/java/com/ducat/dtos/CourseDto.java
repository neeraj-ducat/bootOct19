package com.ducat.dtos;

import java.util.Set;

public class CourseDto {

	private int id;
	private String name;
	private int fee;
	Set<TopicDto> topics;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public Set<TopicDto> getTopics() {
		return topics;
	}
	public void setTopics(Set<TopicDto> topics) {
		this.topics = topics;
	}
	
	
}
