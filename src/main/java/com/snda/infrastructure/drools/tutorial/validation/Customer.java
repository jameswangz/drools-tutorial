package com.snda.infrastructure.drools.tutorial.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Customer {

	private Date dateOfBirth;
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
		account.setCustomer(this);
		this.accounts.add(account);
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	
	
	
	
}
