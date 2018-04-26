package com.fnmps.java.template.multilayer.businesslayer.relationships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnmps.java.template.multilayer.servicelayer.relationships.model.GetAllFriendsIn;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.GetAllFriendsOut;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.ws.GetUserRelationshipsInputMessage;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.ws.GetUserRelationshipsOutputMessage;
import com.fnmps.java.template.multilayer.servicelayer.relationships.services.IUserRelationshipsService;
import com.fnmps.java.template.multilayer.servicelayer.relationships.services.ws.IUserRelationshipsWService;
import com.fnmps.java.template.multilayer.util.MapperManager;

@Component
public class RelationshipsFacade implements IUserRelationshipsService, IUserRelationshipsWService {

	@Autowired
	private MapperManager relationshipsMapper;

	@Override
	public GetUserRelationshipsOutputMessage getUserRelationships(GetUserRelationshipsInputMessage user) {
		// TODO Auto-generated method stub
		return new GetUserRelationshipsOutputMessage();
	}

	@Override
	public GetAllFriendsOut getAllFriends(GetAllFriendsIn user) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
