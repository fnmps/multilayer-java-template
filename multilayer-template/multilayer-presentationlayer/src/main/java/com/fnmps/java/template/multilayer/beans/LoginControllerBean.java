package com.fnmps.java.template.multilayer.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	private ServiceBean serviceBean;

	@PostConstruct
	public void init() {
		System.out.println("initing services");
	}

	public String actionLogin() {
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
	
	public ServiceBean getServiceBean() {
		return serviceBean;
	}

	public void setServiceBean(ServiceBean serviceBean) {
		this.serviceBean = serviceBean;
	}


}
