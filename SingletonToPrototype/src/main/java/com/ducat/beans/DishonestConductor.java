package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DishonestConductor extends Conductor{

	@Autowired
	private Ticket ticket;

	public DishonestConductor() {
		super();
		
	}
	public Ticket getTicket()
	{
		return ticket;
	}
	
}
