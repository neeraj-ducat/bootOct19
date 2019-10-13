package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

	@Autowired
	private B b;
	
	public String toString() {
		
		return "It is A bean.\n It has a "+ b.toString();
	}
}
