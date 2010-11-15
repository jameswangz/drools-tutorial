package com.snda.infrastrure.drools.tutorial;

import hamcrest.Ensure;

import org.drools.KnowledgeBase;
import org.drools.builder.ResourceType;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;


public class SimpleDSLTest extends Ensure {
	
	@Test
	public void test() {
		StatelessKnowledgeSession ksession = kbase().newStatelessKnowledgeSession();
		
		Customer david = new Customer("David");
		ksession.execute(david);
		ensureThat(david.isGreeted());
		
		Customer james = new Customer("James");
		ksession.execute(james);
		not(james.isGreeted());
	}

	private KnowledgeBase kbase() {
		return KnowledgeBases.of(
			ImmutableMap.of(
				"simple.dsl", ResourceType.DSL, 
				"simple.dslr", ResourceType.DSLR
			), 
			null
		);
	}
	
	
}
