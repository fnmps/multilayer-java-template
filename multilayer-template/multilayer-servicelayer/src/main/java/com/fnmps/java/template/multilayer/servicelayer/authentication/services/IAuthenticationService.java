package com.fnmps.java.template.multilayer.servicelayer.authentication.services;

import org.springframework.stereotype.Service;

import com.fnmps.java.template.multilayer.servicelayer.authentication.exceptions.AuthenticationException;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserIn;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserOut;

@Service
public interface IAuthenticationService {

	UserOut authenticate(UserIn user) throws AuthenticationException;
	
}
