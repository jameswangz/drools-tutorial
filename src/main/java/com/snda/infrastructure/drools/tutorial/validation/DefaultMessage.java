package com.snda.infrastructure.drools.tutorial.validation;

import java.util.List;

public class DefaultMessage implements Message {

	private final Type type;
	private final String messageKey;
	private final List<Object> context;

	public DefaultMessage(Type type, String messageKey, List<Object> context) {
		this.type = type;
		this.messageKey = messageKey;
		this.context = context;
	}

	@Override
	public List<Object> getContextOrdered() {
		return this.context;
	}

	@Override
	public String getMessageKey() {
		return this.messageKey;
	}

	@Override
	public Type getType() {
		return this.type;
	}

}
