package com.snda.infrastructure.drools.tutorial.validation;

import com.snda.infrastructure.drools.tutorial.validation.Message.Type;

public interface ReportFactory {

	ValidationReport createValidationReport();

	Message createMessage(Type type, String messageKey, Object... context);

}
