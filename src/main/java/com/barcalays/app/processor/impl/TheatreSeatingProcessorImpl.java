package com.barcalays.app.processor.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.barcalays.app.beans.Row;
import com.barcalays.app.beans.SeatingCapacity;
import com.barcalays.app.beans.Section;
import com.barcalays.app.beans.Theatre;
import com.barcalays.app.beans.TicketInfo;
import com.barcalays.app.json.JsonMapper;
import com.barcalays.app.processor.TheatreSeatingProcessor;

public class TheatreSeatingProcessorImpl implements TheatreSeatingProcessor {

	private JsonMapper jsonMapper = new JsonMapper();

	@Override
	public void process() {

		// create Theatre object based on json
		Theatre theatre = readJson();

		// get seating capacity
		SeatingCapacity seatingCapacity = theatre.getSeatingCapacity();

		// get no of rows in theatre
		List<Row> lstRow = seatingCapacity.getRows();

		int totalSeats = computeTotalSeats(lstRow);

		System.out.println("Total number of seats:" + totalSeats);

		// get list of ticket requests
		List<TicketInfo> lstTicketInfo = theatre.getTicketRequest().getTicketInfo();

		// for every ticket request
		for (TicketInfo ticketInfo : lstTicketInfo) {

			// get the no of tickets
			int tickets = ticketInfo.getTickets();

			boolean seatsAllotted = false;

			// for every row
			for (int i = 0; i < lstRow.size(); i++) {

				if (seatsAllotted) {
					break;
				}

				// get the sections for the row
				List<Section> lstSection = lstRow.get(i).getSections();

				// for every section
				for (int j = 0; j < lstSection.size(); j++) {

					Section section = lstSection.get(j);

					// get the no of seats in section
					int seatsRemaining = section.getSeatsRemaining();

					// check if no of seats in section >= tickets
					if (seatsRemaining >= tickets) {
						seatsAllotted = true;

						// update no of seats remaining in section
						section.setSeatsRemaining(seatsRemaining - tickets);

						// update total no seats in theatre
						totalSeats -= tickets;

						System.out.println(ticketInfo.getName() + " Row " + (i + 1) + " Section " + (j + 1));

						break;
					}

				}

			}

			if (!seatsAllotted) {
				if (totalSeats < tickets) {
					System.out.println(ticketInfo.getName() + " Sorry, we can't handle your party");
				} else {
					System.out.println(ticketInfo.getName() + " Call to split party");
				}
			}

		} // end for

	}// end method

	/**
	 * This method computes and returns total no of seats in the theatre
	 */
	private int computeTotalSeats(List<Row> lstRow) {

		int totalSeats = 0;

		// for every row
		for (Row row : lstRow) {

			// get the section for the row
			List<Section> lstSection = row.getSections();

			// for every section
			for (Section section : lstSection) {

				totalSeats += section.getSeatsRemaining();

			}
		}

		return totalSeats;

	}// end method

	private Theatre readJson() {

		String json = null;

		// read json file
		try {
			json = new String(Files.readAllBytes(Paths.get("src/main/resources/theatre-info.json")));
		} catch (IOException ioException) {
			throw new RuntimeException("An error occurred while reading theatre-info.json...");
		}

		try {
			return jsonMapper.getJsonObject(json);
		} catch (IOException ioException) {
			throw new RuntimeException("An error occurred while creating json object...");
		}

	}

}// end class
