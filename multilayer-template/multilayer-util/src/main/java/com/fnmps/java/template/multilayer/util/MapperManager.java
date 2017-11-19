package com.fnmps.java.template.multilayer.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class MapperManager {

	private List<Mapper<?, ?>> mappers = new ArrayList<>();

	public MapperManager(List<Mapper<?, ?>> mappers) {
		this.mappers = mappers;
	}
	
	public MapperManager(String mappersPackage) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader cl = getClass().getClassLoader();
	    Set<ClassPath.ClassInfo> classesInPackage = ClassPath.from(cl).getTopLevelClassesRecursive(mappersPackage);
	    for( ClassInfo classInPackage : classesInPackage) {
	    	Class<?> clazz = Class.forName(classInPackage.getName());
	    	if(Mapper.class.isAssignableFrom(clazz))
	    		mappers.add((Mapper<?, ?>)clazz.newInstance());
	    }
	}

	@SuppressWarnings("unchecked")
	public < T1, T2> T2 map(T1 source, Class<T2> destinationClass) {
		for (Mapper<?, ?> mapper : mappers) {
			if (mapper.getSourceType() == source.getClass()
					&& mapper.getDestinationType() == destinationClass) {
				return ((Mapper<T1, T2>)mapper).map(source, destinationClass);
			}
		}
		return null;
	}

	public List<Mapper<?, ?>> getMappers() {
		return mappers;
	}

	public void setMappers(List<Mapper<?, ?>> mappers) {
		this.mappers = mappers;
	}

}
