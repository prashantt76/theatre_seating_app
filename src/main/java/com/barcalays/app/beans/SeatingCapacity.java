package com.barcalays.app.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatingCapacity {
		
	@JsonProperty("row")
	private List<Row> rows = new ArrayList<>();

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	
}
