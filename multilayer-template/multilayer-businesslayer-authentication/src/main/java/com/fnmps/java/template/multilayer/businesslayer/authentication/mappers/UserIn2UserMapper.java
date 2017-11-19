package com.fnmps.java.template.multilayer.businesslayer.authentication.mappers;

import com.fnmps.java.template.multilayer.businesslayer.authentication.model.User;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserIn;
import com.fnmps.java.template.multilayer.util.Mapper;

public class UserIn2UserMapper extends Mapper<UserIn, User> {

	@Override
	public User map(UserIn source, User destination) {
		destination.setUsername(source.getUsername());
		return destination;
	}

}
