package com.fnmps.java.template.multilayer.businesslayer.relationships.mappers;


import com.fnmps.java.template.multilayer.businesslayer.relationships.model.User;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserOut;
import com.fnmps.java.template.multilayer.util.Mapper;

public class User2UserOutMapper extends Mapper<User, UserOut> {

	
	@Override
	public UserOut map(User source, UserOut destination) {
		destination.setUsername(source.getUsername());
		destination.setFirstName(source.getFirstName());
		destination.setLastName(source.getLastName());
		return destination;
	}

}
