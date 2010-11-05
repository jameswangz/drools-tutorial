package com.sample;

import java.util.Arrays;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Assert;
import org.junit.Test;


public class StatelessKnowledgeSessionTest extends Assert {

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
		return KnowledgeBases.of("license_applicant.drl");
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
