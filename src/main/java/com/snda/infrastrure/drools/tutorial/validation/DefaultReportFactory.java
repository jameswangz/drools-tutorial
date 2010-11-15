package com.snda.infrastrure.drools.tutorial.validation;

public class DefaultReportFactory implements ReportFactory {

	@Override
	public ValidationReport createValidationReport() {
		return new DefaultValidationSupport();
	}

}
