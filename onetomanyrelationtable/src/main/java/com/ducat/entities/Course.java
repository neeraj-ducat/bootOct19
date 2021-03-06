package com.ducat.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CourseMaster")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int fee;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Course_Topics",
	joinColumns= {@JoinColumn(name="courseId")},
	inverseJoinColumns= {@JoinColumn(name="topicId")})
	private Set<Topic> topics;

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

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	
	
}
