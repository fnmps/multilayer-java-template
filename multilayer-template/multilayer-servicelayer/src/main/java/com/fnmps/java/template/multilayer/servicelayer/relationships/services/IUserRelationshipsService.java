package com.fnmps.java.template.multilayer.servicelayer.relationships.services;

import org.springframework.stereotype.Service;

import com.fnmps.java.template.multilayer.servicelayer.relationships.exceptions.RelationshipsException;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.UserRelationshipsIn;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.UserRelationshipsOut;

@Service
public interface IUserRelationshipsService {

	UserRelationshipsOut getUserRelationships(UserRelationshipsIn user) throws RelationshipsException;
	
}
