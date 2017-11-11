package com.fnmps.java.template.multilayer.dataaccesslayer.repositories;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fnmps.java.template.multilayer.dataaccesslayer.entities.RelationshipEntity;

@Component
public class RelationshipRepository {

	public RelationshipEntity findRelationshipsByUsername(String username) {
		Optional<RelationshipEntity> userOpt = RelationshipEntity.RELATIONSHIP_TABLE.stream()
				.filter(user -> user.getUsername1().equals(username) || user.getUsername2().equals(username))
				.findFirst();
		if (userOpt.isPresent()) {
			return userOpt.get();
		}
		return null;
	}

}
