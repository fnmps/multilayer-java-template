package com.fnmps.java.template.multilayer.businesslayer.authentication;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnmps.java.template.multilayer.businesslayer.authentication.model.User;
import com.fnmps.java.template.multilayer.businesslayer.authentication.services.AuthenticationService;
import com.fnmps.java.template.multilayer.servicelayer.authentication.exceptions.AuthenticationException;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserIn;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserOut;
import com.fnmps.java.template.multilayer.servicelayer.authentication.services.IAuthenticationService;

@Component
public class AuthenticationFacade implements IAuthenticationService {

	@Autowired
	private ModelMapper authenticationMapper;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	
	@Override
	public UserOut authenticate(UserIn userIn) throws AuthenticationException {
 		User user = authenticationMapper.map(userIn, User.class);
		user = authenticationService.authenticateUser(user);
		return authenticationMapper.map(user, UserOut.class);
	}

}
