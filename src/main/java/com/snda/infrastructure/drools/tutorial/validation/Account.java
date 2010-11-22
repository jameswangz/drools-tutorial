package com.snda.infrastructure.drools.tutorial.validation;

import java.math.BigDecimal;

public class Account {
	
	private BigDecimal balance = BigDecimal.ZERO;
	private Type type = Type.TRANSACTIONAL;
	private Customer customer;

	public static enum Type {
		TRANSACTIONAL, STUDENT
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	
	
}
