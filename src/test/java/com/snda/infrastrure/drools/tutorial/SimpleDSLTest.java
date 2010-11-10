package com.snda.infrastrure.drools.tutorial;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.drools.KnowledgeBase;
import org.drools.builder.ResourceType;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;


public class SimpleDSLTest {
	
	@Test
	public void test() {
		StatelessKnowledgeSession ksession = kbase().newStatelessKnowledgeSession();
		
		Customer david = new Customer("David");
		ksession.execute(david);
		assertTrue(david.isGreeted());
		
		Customer james = new Customer("James");
		ksession.execute(james);
		assertFalse(james.isGreeted());
	}

	private KnowledgeBase kbase() {
		return KnowledgeBases.of(
			ImmutableMap.of(
				"simple.dsl", ResourceType.DSL, 
				"simple.dslr", ResourceType.DSLR
			)
		);
	}
	
	
}
