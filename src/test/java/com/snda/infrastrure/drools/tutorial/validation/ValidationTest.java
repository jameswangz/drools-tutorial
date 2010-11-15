package com.snda.infrastrure.drools.tutorial.validation;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.ResourceType;
import org.drools.conf.SequentialOption;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.snda.infrastrure.drools.tutorial.KnowledgeBases;


public class ValidationTest {
	
	private ReportFactory reportFactory;
	private StatelessKnowledgeSession session;

	@Before
	public void initialize() {
		BankingInquiryService inquiryService = new BankInquiryServiceImpl();
		reportFactory = new DefaultReportFactory();
		initializeSession(inquiryService, reportFactory);
	}

	private void initializeSession(BankingInquiryService inquiryService, ReportFactory reportFactory) {
		KnowledgeBaseConfiguration conf = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
		conf.setOption(SequentialOption.YES);
		KnowledgeBase kbase = KnowledgeBases.of(ImmutableMap.of("validation.drl", ResourceType.DRL), conf);
		session = kbase.newStatelessKnowledgeSession();
		session.setGlobal("inquiryService", inquiryService);
		session.setGlobal("reportFactory", reportFactory);
	}
	
	@Test
	public void addressRequired() {
		
	}
	
	
	
}
