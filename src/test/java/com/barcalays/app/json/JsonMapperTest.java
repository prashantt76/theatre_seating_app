package com.barcalays.app.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.barcalays.app.beans.Theatre;

public class JsonMapperTest {

	private JsonMapper jsonMapper = null;

	@Before
	public void setup() {
		jsonMapper = new JsonMapper();
	}

	@Test
	public void testGetJsonObject() throws Exception {
		String json = new String(Files.readAllBytes(Paths.get("src/main/resources/theatre-info.json")));
		Theatre theatre = jsonMapper.getJsonObject(json);

		assertNotNull(theatre);

		// validate seating capacity
		assertEquals(5, theatre.getSeatingCapacity().getRows().size());
		assertEquals(2, theatre.getSeatingCapacity().getRows().get(0).getSections().size());
		assertEquals(6, theatre.getSeatingCapacity().getRows().get(0).getSections().get(0).getSeatsRemaining());

		// validate ticket requests
		assertEquals(8, theatre.getTicketRequest().getTicketInfo().size());
		assertEquals("Smith", theatre.getTicketRequest().getTicketInfo().get(0).getName());
		assertEquals(2, theatre.getTicketRequest().getTicketInfo().get(0).getTickets());
	}

}
