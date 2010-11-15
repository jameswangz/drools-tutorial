package com.snda.infrastrure.drools.tutorial.validation;

public interface ValidationReport {

	boolean contains(String messageKey);

	Message getMessage(String messageKey);

}
