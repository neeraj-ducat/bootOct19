package com.ducat.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Person")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@GenericGenerator(name="inc", strategy="increment")
public class Person {

	@Id
	@GeneratedValue(generator="inc")
	private int id;
	private String name;
	
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
	
	
}
