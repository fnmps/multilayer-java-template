package com.fnmps.java.template.multilayer.util;

import java.lang.reflect.ParameterizedType;

public abstract class Mapper<T1, T2> {

	private Class<T1> sourceType;
	private Class<T1> destinationType;

	@SuppressWarnings("unchecked")
	public Mapper() {
		this.sourceType = (Class<T1>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.destinationType = (Class<T1>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	public abstract T2 map(T1 source, T2 destination);

	public Class<T1> getSourceType() {
		return sourceType;
	}

	public Class<T1> getDestinationType() {
		return destinationType;
	}

}
