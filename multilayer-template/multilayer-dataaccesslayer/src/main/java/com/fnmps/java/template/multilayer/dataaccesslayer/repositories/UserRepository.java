package com.fnmps.java.template.multilayer.dataaccesslayer.repositories;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fnmps.java.template.multilayer.dataaccesslayer.entities.UserEntity;

@Component
public class UserRepository {

	public UserEntity findByUsername(String username) {
		Optional<UserEntity> userOpt = UserEntity.USERS_TABLE.stream().filter(user -> user.getUsername().equals(username)).findFirst();
		if(userOpt.isPresent()) {
			return userOpt.get();
		}
		return null;
	}
	
}
