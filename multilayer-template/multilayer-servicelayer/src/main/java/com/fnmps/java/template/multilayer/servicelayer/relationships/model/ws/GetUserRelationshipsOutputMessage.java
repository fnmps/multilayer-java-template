package com.fnmps.java.template.multilayer.servicelayer.relationships.model.ws;

import java.util.ArrayList;
import java.util.List;

import com.fnmps.java.template.multilayer.servicelayer.relationships.model.types.RelationshipType;

public class GetUserRelationshipsOutputMessage {

	private List<RelationshipType> relationships = new ArrayList<>();

	public List<RelationshipType> getRelationships() {
		if (relationships == null)
			relationships = new ArrayList<>();
		return relationships;
	}

	public void setRelationships(List<RelationshipType> relationships) {
		this.relationships = relationships;
	}

}
