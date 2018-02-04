package com.barcalays.app.processor;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.barcalays.app.processor.impl.TheatreSeatingProcessorImpl;

public class TheatreSeatingProcessorTest {

	private TheatreSeatingProcessor processor = null;

	@Before
	public void setup() {
		processor = new TheatreSeatingProcessorImpl();
	}

	@Test
	public void testProcess() throws Exception {
		Exception exception = null;
		try {
			processor.process();
		} catch (Exception ex) {
			exception = ex;
		}
		assertNull(exception);
	}

}
