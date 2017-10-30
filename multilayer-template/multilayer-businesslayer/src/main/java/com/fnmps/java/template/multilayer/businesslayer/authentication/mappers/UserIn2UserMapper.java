package com.fnmps.java.template.multilayer.businesslayer.authentication.mappers;

import org.modelmapper.PropertyMap;

import com.fnmps.java.template.multilayer.businesslayer.authentication.model.User;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserIn;

public class UserIn2UserMapper extends PropertyMap<UserIn, User> {

	@Override
	protected void configure() {
		map().setUsername(source.getUsername());
	}

}
