package com.fnmps.java.template.multilayer.dataaccesslayer.entities;

import java.util.ArrayList;
import java.util.List;

public class UserEntity {
	
	public final static List<UserEntity> USERS_TABLE = new ArrayList<UserEntity>() {{ 
		UserEntity user = new UserEntity();
		user.setUsername("miksco");
		user.setFirstName("Michael");
		user.setLastName("Scott");
		add(user);
		user = new UserEntity();
		user.setUsername("arrow");
		user.setFirstName("Anne");
		user.setLastName("Rower");
		add(user);
		user = new UserEntity();
		user.setUsername("patrow");
		user.setFirstName("Patrick");
		user.setLastName("Rower");
		add(user);
		
	}};

	private String username;
	private String firstName;
	private String lastName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
