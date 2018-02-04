package com.barcalays.app.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Theatre {

	@JsonProperty("seating-capacity")
	private SeatingCapacity seatingCapacity;

	@JsonProperty("ticket-request")
	private TicketRequest ticketRequest;

	public SeatingCapacity getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(SeatingCapacity seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public TicketRequest getTicketRequest() {
		return ticketRequest;
	}

	public void setTicketRequest(TicketRequest ticketRequest) {
		this.ticketRequest = ticketRequest;
	}
		
}
