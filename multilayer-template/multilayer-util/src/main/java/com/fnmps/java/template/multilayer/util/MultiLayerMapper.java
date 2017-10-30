package com.fnmps.java.template.multilayer.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class MultiLayerMapper extends ModelMapper{

	public MultiLayerMapper(List<Class<PropertyMap<?, ?>>> mappers) throws InstantiationException, IllegalAccessException {
		for(Class<PropertyMap<?, ?>> mapper : mappers) {
			super.addMappings(mapper.newInstance());
		}
	}
}
