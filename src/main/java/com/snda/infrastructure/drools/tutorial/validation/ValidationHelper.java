package com.snda.infrastructure.drools.tutorial.validation;

import org.drools.runtime.KnowledgeRuntime;
import org.drools.runtime.rule.RuleContext;

public class ValidationHelper {
	
	public static void warning(RuleContext kcontext, Object... context) {
		KnowledgeRuntime knowledgeRuntime = kcontext.getKnowledgeRuntime();
		ReportFactory reportFactory = (ReportFactory) knowledgeRuntime.getGlobal("reportFactory");
		ValidationReport valiationReport = (ValidationReport) knowledgeRuntime.getGlobal("validationReport");
		valiationReport.addMessage(reportFactory.createMessage(Message.Type.WARNING, kcontext.getRule().getName(), context));
	}
	
}
