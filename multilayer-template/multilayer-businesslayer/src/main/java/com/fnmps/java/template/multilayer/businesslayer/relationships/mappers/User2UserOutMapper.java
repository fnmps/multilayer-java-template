package com.fnmps.java.template.multilayer.businesslayer.relationships.mappers;

import org.modelmapper.PropertyMap;

import com.fnmps.java.template.multilayer.businesslayer.authentication.model.User;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserOut;

public class User2UserOutMapper extends PropertyMap<User, UserOut> {

	@Override
	protected void configure() {
		map().setUsername(source.getUsername());
		map().setFirstName(source.getFirstName());
		map().setLastName(source.getLastName());
	}

}
