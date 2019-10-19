package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope("prototype")
public class A {

	
	private B b;

	public A() {
		super();
		System.out.println("A object is created.");
	}
	@Autowired
	public A(B b) {
		this.b =b;
		System.out.println("A object is created and B reference is injected.");
	}
	
	
	public void setB(B b) {
		this.b = b;
		System.out.println("setB() of A is invoked.");
	}



	public String toString()
	{
		return "It is A object, it has a "+b.toString();
	}
	
}
