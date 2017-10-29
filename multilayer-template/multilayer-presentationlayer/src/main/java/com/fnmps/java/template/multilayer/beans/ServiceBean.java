package com.fnmps.java.template.multilayer.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.stereotype.Controller;

@Named
@Controller
public class ServiceBean implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2902871467070425093L;

	@PostConstruct
	public void init() {
		System.out.println("initing services");
	}

}
