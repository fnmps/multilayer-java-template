package com.fnmps.java.template.multilayer.servicelayer.relationships.services.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.fnmps.java.template.multilayer.servicelayer.relationships.exceptions.RelationshipsException;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.ws.GetUserRelationshipsInputMessage;
import com.fnmps.java.template.multilayer.servicelayer.relationships.model.ws.GetUserRelationshipsOutputMessage;

@WebService
public interface IUserRelationshipsWService {

	@WebMethod
	@WebResult(name = "GetUserRelationshipsOutputMessage")
	GetUserRelationshipsOutputMessage getUserRelationships(
			@WebParam(name = "GetUserRelationshipsInputMessage") GetUserRelationshipsInputMessage user)
			throws RelationshipsException;

}
