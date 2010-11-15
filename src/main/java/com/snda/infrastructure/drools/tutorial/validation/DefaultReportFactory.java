package com.snda.infrastructure.drools.tutorial.validation;

import java.util.Arrays;

import com.snda.infrastructure.drools.tutorial.validation.Message.Type;

public class DefaultReportFactory implements ReportFactory {

	@Override
	public ValidationReport createValidationReport() {
		return new DefaultValidationSupport();
	}

	@Override
	public Message createMessage(Type type, String messageKey, Object... context) {
		return new DefaultMessage(type, messageKey, Arrays.asList(context));
	}

}
