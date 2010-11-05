package com.sample;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Application {
	
	private boolean valid = true;
	private String dateApplied = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(String dateApplied) {
		this.dateApplied = dateApplied;
	}
	
	
	
	
}
