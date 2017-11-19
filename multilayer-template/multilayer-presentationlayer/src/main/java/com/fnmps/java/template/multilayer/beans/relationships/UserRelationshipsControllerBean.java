package com.fnmps.java.template.multilayer.beans.relationships;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import com.fnmps.java.template.multilayer.beans.common.ServiceCatalog;
import com.fnmps.java.template.multilayer.beans.common.UserBean;

@ManagedBean
@ViewScoped
public class UserRelationshipsControllerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -547451879054480330L;

	@ManagedProperty("#{userBean}")
	private UserBean userBean;

	@ManagedProperty("#{userRelationshipsBackingBean}")
	private UserRelationshipsBackingBean userRelationshipsBackingBean;

	@ManagedProperty("#{serviceCatalog}")
	private ServiceCatalog serviceCatalog;

	public void actionShowFriends() {

	}

	public void actionShowColleagues() {

	}

	public void actionShowAll() {

	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public UserRelationshipsBackingBean getUserRelationshipsBackingBean() {
		return userRelationshipsBackingBean;
	}

	public void setUserRelationshipsBackingBean(UserRelationshipsBackingBean userRelationshipsBackingBean) {
		this.userRelationshipsBackingBean = userRelationshipsBackingBean;
	}

	public ServiceCatalog getServiceCatalog() {
		return serviceCatalog;
	}

	public void setServiceCatalog(ServiceCatalog serviceCatalog) {
		this.serviceCatalog = serviceCatalog;
	}
	
	
}
