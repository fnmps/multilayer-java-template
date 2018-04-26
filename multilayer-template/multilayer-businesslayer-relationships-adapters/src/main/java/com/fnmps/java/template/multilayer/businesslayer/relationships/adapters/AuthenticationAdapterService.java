package com.fnmps.java.template.multilayer.businesslayer.relationships.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnmps.java.template.multilayer.businesslayer.common.exceptions.ExternalServiceException;
import com.fnmps.java.template.multilayer.servicelayer.authentication.exceptions.AuthenticationException;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserIn;
import com.fnmps.java.template.multilayer.servicelayer.authentication.services.IAuthenticationService;

@Component
public class AuthenticationAdapterService implements IAuthenticationAdapterService {

	@Autowired
	private IAuthenticationService authService;

	@Override
	public boolean isValidUser(String username) throws ExternalServiceException {
		UserIn user = new UserIn();
		user.setUsername(username);
		try {
			return (authService.authenticate(user) != null);
		} catch (AuthenticationException e) {
			return false;
		} catch (Exception e) {
			throw new ExternalServiceException();
		}
	}
}
