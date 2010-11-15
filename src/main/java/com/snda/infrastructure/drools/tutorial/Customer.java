package com.snda.infrastructure.drools.tutorial;

public class Customer {
	
	private final String firstName;
	private boolean greeted;

	public Customer(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public boolean isGreeted() {
		return greeted;
	}

	public void setGreeted(boolean greeted) {
		this.greeted = greeted;
	}

	
}
