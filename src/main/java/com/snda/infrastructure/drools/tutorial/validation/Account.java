package com.snda.infrastructure.drools.tutorial.validation;

import java.math.BigDecimal;

public class Account {
	
	private BigDecimal balance = BigDecimal.ZERO;

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	
	
}
