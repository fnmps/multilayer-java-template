package com.fnmps.java.template.multilayer.servicelayer.relationships.model;

import java.util.ArrayList;
import java.util.List;

import com.fnmps.java.template.multilayer.servicelayer.relationships.model.types.RelationshipType;

public class UserRelationshipsOut {

	private String username;
	private List<RelationshipType> relationships = new ArrayList<>();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<RelationshipType> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<RelationshipType> relationships) {
		this.relationships = relationships;
	}
	
	
}
