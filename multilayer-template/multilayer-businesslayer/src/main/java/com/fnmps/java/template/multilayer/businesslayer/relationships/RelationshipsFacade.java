package com.fnmps.java.template.multilayer.businesslayer.relationships;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnmps.java.template.multilayer.servicelayer.relationships.exceptions.RelationshipsException;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.UserRelationshipsIn;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.UserRelationshipsOut;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.ws.GetUserRelationshipsInputMessage;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.ws.GetUserRelationshipsOutputMessage;
import com.fnmps.java.template.multilayer.servicelayer.relationships.services.IUserRelationshipsService;
import com.fnmps.java.template.multilayer.servicelayer.relationships.services.ws.IUserRelationshipsWService;

@Component
public class RelationshipsFacade implements IUserRelationshipsService, IUserRelationshipsWService {

	@Autowired
	private ModelMapper relationshipsMapper;

	@Override
	public GetUserRelationshipsOutputMessage getUserRelationships(GetUserRelationshipsInputMessage user)
			throws RelationshipsException {
		// TODO Auto-generated method stub
		return new GetUserRelationshipsOutputMessage();
	}

	@Override
	public UserRelationshipsOut getUserRelationships(UserRelationshipsIn user) throws RelationshipsException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
