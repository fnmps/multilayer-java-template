package com.fnmps.java.template.multilayer.beans.common;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fnmps.java.template.multilayer.servicelayer.authentication.services.IAuthenticationService;
import com.fnmps.java.template.multilayer.servicelayer.relationships.services.IUserRelationshipsService;

@Controller
@Scope("application")
public class ServiceCatalog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5505340729547499164L;

	@Autowired
	private IAuthenticationService authenticationService;

	@Autowired
	private IUserRelationshipsService userRelationshipsService;

	@PostConstruct
	public void init() {
		System.out.println("Initing ServiceCatalog...");
	}

	public IAuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public IUserRelationshipsService getUserRelationshipsService() {
		return userRelationshipsService;
	}

}
