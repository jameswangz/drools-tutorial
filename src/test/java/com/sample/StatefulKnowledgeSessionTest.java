package com.sample;

import java.util.HashMap;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.builder.ResourceType;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;


public class StatefulKnowledgeSessionTest extends Assert {
	
	private static final String KITCHEN = "kitchen";
	private static final String BEDROOM = "bedroom";
	private static final String OFFICE = "office";
	private static final String LIVINGROOM = "livingroom";

	@Test
	public void test() {
		KnowledgeBase kbase = KnowledgeBases.of(ImmutableMap.of("fire_alarm.drl", ResourceType.DRL));
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

		String[] names = new String[] {KITCHEN, BEDROOM, OFFICE, LIVINGROOM};
		Map<String, Room> name2room = new HashMap<String, Room>();
		
		for (String name : names) {
			Room room = new Room(name);
			name2room.put(name, room);
			ksession.insert(room);
			Sprinkler sprinkler = new Sprinkler(room);
			ksession.insert(sprinkler);
		}
	
		Fire kitchenFire = new Fire(name2room.get(KITCHEN));
		Fire officeFire = new Fire(name2room.get(OFFICE));
		
		FactHandle kitchenFireHandle = ksession.insert(kitchenFire);
		FactHandle officeHandle = ksession.insert(officeFire);
		
		ksession.fireAllRules();
		
		ksession.retract(kitchenFireHandle);
		ksession.retract(officeHandle);
		
		ksession.fireAllRules();
		
		ksession.dispose();
	}
	
}
