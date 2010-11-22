package com.snda.infrastructure.drools.tutorial.validation;

import java.util.Date;

import org.drools.runtime.KnowledgeRuntime;
import org.drools.runtime.rule.RuleContext;
import org.joda.time.DateMidnight;
import org.joda.time.Years;

import com.snda.infrastructure.drools.tutorial.validation.Message.Type;

public class ValidationHelper {
	
	public static void warning(RuleContext kcontext, Object... context) {
		addMessage(kcontext, Message.Type.WARNING, context);
	}

	public static void error(RuleContext kcontext, Object... context) {
		addMessage(kcontext, Message.Type.ERROR, context);
	}

	private static void addMessage(RuleContext kcontext, Type messageType, Object... context) {
		KnowledgeRuntime knowledgeRuntime = kcontext.getKnowledgeRuntime();
		ReportFactory reportFactory = (ReportFactory) knowledgeRuntime.getGlobal("reportFactory");
		ValidationReport valiationReport = (ValidationReport) knowledgeRuntime.getGlobal("validationReport");
		valiationReport.addMessage(reportFactory.createMessage(messageType, kcontext.getRule().getName(), context));
	}
	
	
	public static int yearsPassedSince(Date date) {
		return Years.yearsBetween(new DateMidnight(date), new DateMidnight()).getYears();
	}
	
	
}
