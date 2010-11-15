package com.snda.infrastructure.drools.tutorial;

import java.sql.Date;

public class Application {
	
	private boolean valid = true;
	private Date dateApplied = new Date(System.currentTimeMillis());
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Date getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}
	
	
	
	
}
