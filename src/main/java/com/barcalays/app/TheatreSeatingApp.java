package com.barcalays.app;

import com.barcalays.app.processor.TheatreSeatingProcessor;
import com.barcalays.app.processor.impl.TheatreSeatingProcessorImpl;

public class TheatreSeatingApp {

	public static void main(String[] args) {
		TheatreSeatingProcessor theatreSeatingProcessor = new TheatreSeatingProcessorImpl();
		theatreSeatingProcessor.process();
	}
}
