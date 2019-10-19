package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.A;

@SpringBootApplication
public class AppOne {

	public static void main(String[] args) {
	// application is started and reference of the 
	// IOC Container is obtained.
	ApplicationContext ctx = SpringApplication.run(AppOne.class, args);	
	System.out.println("Requesting A bean from the container...");
	A a1 = (A) ctx.getBean("a");
	System.out.println("printing first a object...");
	System.out.println(a1);
	System.out.println("Requesting another A bean from the container...");
	A a2 = (A) ctx.getBean("a");
	System.out.println("printing second a object...");
	System.out.println(a2);
	}

}
