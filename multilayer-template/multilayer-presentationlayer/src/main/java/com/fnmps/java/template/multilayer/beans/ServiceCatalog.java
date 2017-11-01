package com.fnmps.java.template.multilayer.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fnmps.java.template.multilayer.servicelayer.authentication.services.IAuthenticationService;

@Controller
public class ServiceCatalog implements Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5505340729547499164L;
	
	@Autowired
	private IAuthenticationService authenticationService;

	@PostConstruct
	public void init() {
		System.out.println("Initing ServiceCatalog...");
	}
	
	public IAuthenticationService getAuthenticationService() {
		return authenticationService;
	}


	public void setAuthenticationService(IAuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}	
	
}
