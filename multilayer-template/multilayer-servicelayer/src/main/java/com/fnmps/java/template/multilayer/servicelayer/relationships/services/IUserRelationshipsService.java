package com.fnmps.java.template.multilayer.servicelayer.relationships.services;

import org.springframework.stereotype.Service;

import com.fnmps.java.template.multilayer.servicelayer.relationships.exceptions.RelationshipsException;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.GetAllFriendsIn;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.GetAllFriendsOut;

@Service
public interface IUserRelationshipsService {

	GetAllFriendsOut getAllFriends(GetAllFriendsIn input) throws RelationshipsException;
	
}
