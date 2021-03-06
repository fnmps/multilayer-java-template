package com.fnmps.java.template.multilayer.businesslayer.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnmps.java.template.multilayer.businesslayer.authentication.exceptions.UserNotFoundException;
import com.fnmps.java.template.multilayer.businesslayer.authentication.model.User;
import com.fnmps.java.template.multilayer.businesslayer.authentication.services.AuthenticationService;
import com.fnmps.java.template.multilayer.servicelayer.authentication.exceptions.AuthenticationException;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserIn;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserOut;
import com.fnmps.java.template.multilayer.servicelayer.authentication.services.IAuthenticationService;
import com.fnmps.java.template.multilayer.util.MapperManager;

@Component
public class AuthenticationFacade implements IAuthenticationService {

	@Autowired
	private MapperManager authenticationMapper;

	@Autowired
	private AuthenticationService authenticationService;

	@Override
	public UserOut authenticate(UserIn userIn) throws AuthenticationException {
		User user = authenticationMapper.map(userIn, User.class);
		try {
			user = authenticationService.authenticateUser(user);
		} catch (UserNotFoundException e) {
			throw new AuthenticationException();
		}
		return authenticationMapper.map(user, UserOut.class);
	}

}
