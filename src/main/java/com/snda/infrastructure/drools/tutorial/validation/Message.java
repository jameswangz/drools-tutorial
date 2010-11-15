package com.snda.infrastructure.drools.tutorial.validation;

import java.util.List;

public interface Message {
	
	enum Type {
		WARNING, ERROR
	}
	
	Type getType();
	
	String getMessageKey();
	
	List<Object> getContextOrdered();
	
	
}
