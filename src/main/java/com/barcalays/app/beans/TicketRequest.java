package com.barcalays.app.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketRequest {
		
	@JsonProperty("ticket-info")
	private List<TicketInfo> ticketInfo = new ArrayList<>();

	public List<TicketInfo> getTicketInfo() {
		return ticketInfo;
	}

	public void setTicketInfo(List<TicketInfo> ticketInfo) {
		this.ticketInfo = ticketInfo;
	}
	
}
