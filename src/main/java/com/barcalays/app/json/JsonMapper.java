package com.barcalays.app.json;

import java.io.IOException;

import com.barcalays.app.beans.Theatre;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper extends ObjectMapper {

	private static final long serialVersionUID = 1l;
	
	public JsonMapper() {
		super();
		configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public Theatre getJsonObject(String json) throws IOException {		
		Theatre theatre = readValue(json, Theatre.class);
		return theatre;
	}

}
