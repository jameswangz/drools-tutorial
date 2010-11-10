package com.sample;

import java.util.Arrays;

import org.drools.KnowledgeBase;
import org.drools.builder.ResourceType;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;


public class StatelessKnowledgeSessionTest extends Assert {

	@Before
	public void before() {
		System.setProperty("drools.dateformat", "yyyy-MM-dd");
	}
	
	@Test
	public void age() {
		StatelessKnowledgeSession ksession = kbase().newStatelessKnowledgeSession();
		Applicant applicant = new Applicant("James Bond", 16);
		Application application = new Application();
		assertTrue(application.isValid());
		ksession.execute(Arrays.asList(new Object[] {applicant, application}));
		assertFalse(application.isValid());
	}

	private KnowledgeBase kbase() {
		return KnowledgeBases.of(ImmutableMap.of("license_applicant.drl", ResourceType.DRL));
	}

	@Test
	public void dateApplied() {
		StatelessKnowledgeSession ksession = kbase().newStatelessKnowledgeSession();
		Applicant applicant = new Applicant("James Bond", 19);
		Application application = new Application();
		assertTrue(application.isValid());
		ksession.execute(Arrays.asList(new Object[] {applicant, application}));
		assertFalse(application.isValid());
	}
	
}
