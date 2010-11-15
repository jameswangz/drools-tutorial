package com.snda.infrastructure.drools.tutorial.validation;

import java.util.Set;

public interface ValidationReport {

	Set<Message> getMessages();
	
	boolean contains(String messageKey);

	Message getMessage(String messageKey);

	void addMessage(Message createMessage);
	
}
