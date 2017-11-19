package com.fnmps.java.template.multilayer.beans.login;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class LoginBackingBean  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5219117185894648701L;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
		
}
