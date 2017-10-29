package com.fnmps.java.template.multilayer.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
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