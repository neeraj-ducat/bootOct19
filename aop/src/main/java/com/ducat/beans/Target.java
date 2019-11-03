package com.ducat.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Target implements ABC {

	
	@Override
	public void a()
	{
		System.out.println("a() of Target is invoked.");
	}
	
	@Override
	public String b()
	{
		System.out.println("b() of Target is invoked, returning success...");
		return "success";
	}
	
	@Override
	public void c(int x) throws Exception
	{
		System.out.println("c() of target is invoked.");
		if(x < 0)
		{
			System.out.println("throwing exception...");
			throw(new Exception("input must be > 0"));
		}
		else
			System.out.println("returning normally.");
	}
}
