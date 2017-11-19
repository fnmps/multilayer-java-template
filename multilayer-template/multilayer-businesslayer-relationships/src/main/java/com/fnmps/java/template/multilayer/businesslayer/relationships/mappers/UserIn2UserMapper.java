package com.fnmps.java.template.multilayer.businesslayer.relationships.mappers;

import com.fnmps.java.template.multilayer.businesslayer.relationships.model.User;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserIn;
import com.fnmps.java.template.multilayer.util.Mapper;

public class UserIn2UserMapper extends Mapper<UserIn, User> {

	@Override
	public User map(UserIn source, User destination) {
		destination.setUsername(source.getUsername());
		return destination;
	}

}
