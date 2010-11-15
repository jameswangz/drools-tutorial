package com.snda.infrastructure.drools.tutorial.validation;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.googlecode.functionalcollections.FunctionalIterables;

public class DefaultValidationSupport implements ValidationReport {
	
	private Map<Message.Type, Message> messagesMap = Maps.newHashMap();
	
	@Override
	public boolean contains(final String messageKey) {
		return getMessage(messageKey) != null;
	}

	@Override
	public Message getMessage(final String messageKey) {
		return FunctionalIterables.make(getMessages()).detect(new Predicate<Message>() {
			@Override
			public boolean apply(Message input) {
				return input.getMessageKey().equals(messageKey);
			}
		});
	}

	@Override
	public Set<Message> getMessages() {
		return new HashSet<Message>(messagesMap.values());
	}

	@Override
	public void addMessage(Message message) {
		this.messagesMap.put(message.getType(), message);
	}

}
