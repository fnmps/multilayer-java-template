package com.fnmps.java.template.multilayer.businesslayer.authentication;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnmps.java.template.multilayer.servicelayer.authentication.exceptions.AuthenticationException;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserIn;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserOut;
import com.fnmps.java.template.multilayer.servicelayer.authentication.services.IAuthenticationService;

@Component
public class AuthenticationFacade implements IAuthenticationService {

	@Autowired
	ModelMapper mapper;
	
	@Override
	public UserOut authenticate(UserIn user) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

}
