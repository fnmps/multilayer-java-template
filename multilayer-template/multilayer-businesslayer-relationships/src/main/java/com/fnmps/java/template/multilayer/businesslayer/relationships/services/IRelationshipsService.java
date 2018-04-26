package com.fnmps.java.template.multilayer.businesslayer.relationships.services;

import com.fnmps.java.template.multilayer.businesslayer.authentication.exceptions.UserNotFoundException;
import com.fnmps.java.template.multilayer.businesslayer.relationships.model.User;

public interface IRelationshipsService {

	public User authenticateUser(User user) throws UserNotFoundException;
}
