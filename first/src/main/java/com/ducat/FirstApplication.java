package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.A;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		
	ApplicationContext container =	SpringApplication.run(FirstApplication.class, args);
	System.out.println("Requesting A bean from the container...");
	A a = (A)container.getBean("a");
	System.out.println(a);
	}

}
