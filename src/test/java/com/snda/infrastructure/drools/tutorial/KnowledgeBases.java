package com.snda.infrastructure.drools.tutorial;

import java.util.Map;
import java.util.Map.Entry;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;

public abstract class KnowledgeBases {

	public static KnowledgeBase of(Map<String, ResourceType> resourceMap, KnowledgeBaseConfiguration conf) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		
		for (Entry<String, ResourceType> entry : resourceMap.entrySet()) {
			kbuilder.add(ResourceFactory.newClassPathResource(entry.getKey()), entry.getValue());
		}
		
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		
		if (!errors.isEmpty()) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Couldn't parse knowledge");
		}
		
		KnowledgeBase kbase = null;
		
		if (conf == null) {
			kbase = KnowledgeBaseFactory.newKnowledgeBase();
		} else {
			kbase = KnowledgeBaseFactory.newKnowledgeBase(conf);			
		}
		
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

}
