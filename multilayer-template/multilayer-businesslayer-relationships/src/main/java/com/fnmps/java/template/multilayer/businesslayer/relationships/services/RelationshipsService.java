package com.fnmps.java.template.multilayer.businesslayer.relationships.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnmps.java.template.multilayer.businesslayer.authentication.exceptions.UserNotFoundException;
import com.fnmps.java.template.multilayer.businesslayer.relationships.model.User;
import com.fnmps.java.template.multilayer.dataaccesslayer.entities.UserEntity;
import com.fnmps.java.template.multilayer.dataaccesslayer.repositories.UserRepository;

@Component
public class RelationshipsService implements IRelationshipsService {

	@Autowired
	private UserRepository userRepository;
	
	public User authenticateUser(User user) throws UserNotFoundException {
		UserEntity userEntitiy = userRepository.findByUsername(user.getUsername());
		
		if(userEntitiy == null)
			throw new UserNotFoundException();
		
		user.setFistName(userEntitiy.getFirstName());
		user.setLastName(userEntitiy.getLastName());
		
		return user;
	}
}
