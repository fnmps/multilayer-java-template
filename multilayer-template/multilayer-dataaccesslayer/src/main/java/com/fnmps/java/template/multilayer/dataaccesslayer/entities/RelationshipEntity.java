package com.fnmps.java.template.multilayer.dataaccesslayer.entities;

import java.util.ArrayList;
import java.util.List;

public class RelationshipEntity {

	public final static String TYPE_COLLEAGUE = "COLLEAGUE";
	public final static String TYPE_FRIEND = "FRIEND";
	public final static String TYPE_UNKOWN = "UNKOWN";
	
	public final static List<RelationshipEntity> RELATIONSHIP_TABLE = new ArrayList<RelationshipEntity>() {
		{
			RelationshipEntity relationship = new RelationshipEntity();
			relationship.setUsername1("miksco");
			relationship.setUsername2("arrow");
			relationship.setType(TYPE_FRIEND);
			add(relationship);
			relationship = new RelationshipEntity();
			relationship.setUsername1("arrow");
			relationship.setUsername2("patrow");
			relationship.setType(TYPE_FRIEND);
			add(relationship);
			relationship = new RelationshipEntity();
			relationship.setUsername1("patrow");
			relationship.setUsername2("miksco");
			relationship.setType(TYPE_COLLEAGUE);
			add(relationship);

		}
	};

	private String username1;
	private String username2;
	private String type;

	public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String username2) {
		this.username2 = username2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
