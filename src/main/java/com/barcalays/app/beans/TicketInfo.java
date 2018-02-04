package com.barcalays.app.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketInfo {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("tickets")
	private int tickets;

	public TicketInfo()
	{
		
	}
	public TicketInfo(String name, int tickets) {
		this.name = name;
		this.tickets = tickets;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int ticket) {
		this.tickets = ticket;
	}
	
	
	

}
