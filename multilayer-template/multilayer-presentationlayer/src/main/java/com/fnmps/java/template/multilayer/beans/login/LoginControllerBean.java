package com.fnmps.java.template.multilayer.beans.login;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.fnmps.java.template.multilayer.beans.common.ServiceCatalog;
import com.fnmps.java.template.multilayer.beans.common.UserBean;
import com.fnmps.java.template.multilayer.servicelayer.authentication.exceptions.AuthenticationException;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserIn;
import com.fnmps.java.template.multilayer.servicelayer.authentication.model.UserOut;

@ManagedBean
@ViewScoped
public class LoginControllerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8207346187485566347L;

	@ManagedProperty("#{userBean}")
	private UserBean userBean;

	@ManagedProperty("#{loginBackingBean}")
	private LoginBackingBean loginBackingBean;

	@ManagedProperty("#{serviceCatalog}")
	private ServiceCatalog serviceCatalog;

	@PostConstruct
	public void init() {
		System.out.println("initing LoginControllerBean");
	}

	public String actionLogin() {
		UserOut userOut = null;
		try {
			UserIn userIn = new UserIn();
			userIn.setUsername(loginBackingBean.getUsername());
			userOut = serviceCatalog.getAuthenticationService().authenticate(userIn);
		} catch (AuthenticationException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No such user", ""));
			return null;
		}

		userBean.setUsername(userOut.getUsername());
		userBean.setName(userOut.getLastName() + ", " + userOut.getLastName());

		return "/pages/relationships/relationships.xhtml?faces-redirect=true";
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

	public ServiceCatalog getServiceCatalog() {
		return serviceCatalog;
	}

	public void setServiceCatalog(ServiceCatalog serviceCatalog) {
		this.serviceCatalog = serviceCatalog;
	}

}
