package com.fnmps.java.template.multilayer.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.fnmps.java.template.multilayer.servicelayer.authentication.exceptions.AuthenticationException;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserIn;
import com.fnmps.java.template.multilayer.servicelayer.authentication.services.IAuthenticationService;

@Named
@ViewScoped
public class LoginControllerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8207346187485566347L;

	@Inject
	private UserBean userBean;

	@Inject
	private LoginBackingBean loginBackingBean;

	@Inject
	private IAuthenticationService authenticationService;

	@PostConstruct
	public void init() {
		System.out.println("initing services");
	}

	public String actionLogin() {	
		
		try {
			UserIn user = new UserIn();
			user.setUsername(loginBackingBean.getUsername());
			authenticationService.authenticate(user );
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		userBean.setUsername(loginBackingBean.getUsername());		
		return "userRelationships.xhtml";
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public LoginBackingBean getLoginBackingBean() {
		return loginBackingBean;
	}

	public void setLoginBackingBean(LoginBackingBean loginBackingBean) {
		this.loginBackingBean = loginBackingBean;
	}

	public IAuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(IAuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}


}
