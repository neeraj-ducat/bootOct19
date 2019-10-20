package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HonestConductor extends Conductor{

	@Autowired
	private ApplicationContext ctx;

	public HonestConductor() {
		super();
		
	}
	public Ticket getTicket()
	{
		return (Ticket)ctx.getBean("ticket");
	}
	
}
