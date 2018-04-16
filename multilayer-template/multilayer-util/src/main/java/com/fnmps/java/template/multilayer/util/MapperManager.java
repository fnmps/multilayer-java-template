package com.fnmps.java.template.multilayer.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class MapperManager {

	// configs
	private boolean mapByName = false;
	private boolean caseSensitive = false;
	private boolean overrideExistingFields = false;

	private List<Mapper<?, ?>> mappers = new ArrayList<Mapper<?, ?>>();

	public MapperManager(List<Mapper<?, ?>> mappers) {
		this.mappers = mappers;
	}

	public MapperManager(String mappersPackage)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader cl = getClass().getClassLoader();
		Set<ClassPath.ClassInfo> classesInPackage = ClassPath.from(cl).getTopLevelClassesRecursive(mappersPackage);
		for (ClassInfo classInPackage : classesInPackage) {
			Class<?> clazz = Class.forName(classInPackage.getName());
			if (Mapper.class.isAssignableFrom(clazz)) {
				mappers.add((Mapper<?, ?>) clazz.newInstance());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T1, T2> T2 map(T1 source, T2 destination) {
		for (Mapper<?, ?> mapper : mappers) {
			if (mapper.getSourceType() == source.getClass() && mapper.getDestinationType() == destination.getClass()) {
				if (mapByName) {
					mapByName(source, destination);
				}
				return ((Mapper<T1, T2>) mapper).map(source, destination);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T1, T2> T2 map(T1 source, Class<T2> destinationClass) {
		for (Mapper<?, ?> mapper : mappers) {
			try {
				if (mapper.getSourceType() == source.getClass() && mapper.getDestinationType() == destinationClass) {
					T2 destination = destinationClass.newInstance();
					if (mapByName) {
						mapByName(source, destination);
					}
					return ((Mapper<T1, T2>) mapper).map(source, destination);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	private void mapByName(Object source, Object destination) {
		Class<? extends Object> destinationClass = destination.getClass();
		Class<? extends Object> sourceClass = source.getClass();
		for (Method m1 : destinationClass.getMethods()) {
			if (m1.getName().startsWith("set")) {
				String fieldName = m1.getName().substring(3, m1.getName().length());
				Class<?> fieldType;
				if (m1.getParameterTypes().length == 1) {
					fieldType = m1.getParameterTypes()[0];
				} else {
					continue;
				}
				for (Method m2 : sourceClass.getMethods()) {
					try {
						if (m2.getName().startsWith("get") && fieldType.isAssignableFrom(m2.getReturnType())) {
							mapField(m2, m1, m2.getName().substring(3, m2.getName().length()), fieldName, source,
									destination);
							break;
						} else if (m2.getName().startsWith("is") && fieldType.isAssignableFrom(m2.getReturnType())) {
							mapField(m2, m1, m2.getName().substring(2, m2.getName().length()), fieldName, source,
									destination);
							break;
						}
					} catch (Exception e) {
						// try another method if it did not work
					}
				}
			}
		}
	}

	private void mapField(Method sourceMethod, Method destinationMethod, String sourceFieldName,
			String destinationFieldName, Object source, Object destination) throws Exception {
		Method getterMethod = getMethodFromClass(destination.getClass(), "get" + destinationFieldName);
		if (sourceFieldName.equals(destinationFieldName)) {
			if (getterMethod == null || getterMethod.invoke(destination, new Object[0]) == null) {
				destinationMethod.invoke(destination, sourceMethod.invoke(source, new Object[0]));
				return;
			} else if (overrideExistingFields) {
				destinationMethod.invoke(destination, sourceMethod.invoke(source, new Object[0]));
				return;
			}
		} else if (!this.caseSensitive && sourceFieldName.equalsIgnoreCase(destinationFieldName)) {
			if (getterMethod == null || getterMethod.invoke(destination, new Object[0]) == null) {
				destinationMethod.invoke(destination, sourceMethod.invoke(source, new Object[0]));
				return;
			} else if (overrideExistingFields) {
				destinationMethod.invoke(destination, sourceMethod.invoke(source, new Object[0]));
				return;
			}
		}

		throw new Exception();
	}

	private Method getMethodFromClass(Class<?> aClass, String methodName) {
		for (Method m1 : aClass.getMethods()) {
			if (m1.getName().equals(methodName)) {
				return m1;
			} else if (!this.caseSensitive && m1.getName().equalsIgnoreCase(methodName)) {
				return m1;
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

	public boolean isMapByName() {
		return mapByName;
	}

	public void setMapByName(boolean mapByName) {
		this.mapByName = mapByName;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	public boolean isOverrideExistingFields() {
		return overrideExistingFields;
	}

	public void setOverrideExistingFields(boolean overrideExistingFields) {
		this.overrideExistingFields = overrideExistingFields;
	}

}
