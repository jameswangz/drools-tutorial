package com.snda.infrastructure.drools.tutorial.validation;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {

	private Address address;
	private Collection<Account> accounts = new ArrayList<Account>();

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Collection<Account> getAccounts() {
		return accounts ;
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	
	
}
