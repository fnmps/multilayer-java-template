package com.fnmps.java.template.multilayer.util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

/**
 * Class responsible for mapping classes.
 *
 */
public class MapperManager {

	private final static Logger LOGGER = Logger.getLogger(MapperManager.class.getName());

	// configs
	/**
	 * if true, map fields by their names
	 */
	private boolean mapByName = false;
	/**
	 * if true, when mapping fields by name, map them case sensitive
	 */
	private boolean caseSensitive = false;
	/**
	 * if true, map the fields that already have a value on the destination
	 */
	private boolean overrideExistingFields = false;

	/**
	 * list of mappers that should be used to do custom mapping of fields
	 */
	private List<Mapper<?, ?>> mappers = new ArrayList<Mapper<?, ?>>();

	/**
	 * @param mappers
	 *            - a list of mappers that will be used to map objects
	 */
	public MapperManager(List<Mapper<?, ?>> mappers) {
		this.mappers = mappers;
	}

	/**
	 * @param mappersPackages
	 *            - an array of packages that contain mapper classes
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public MapperManager(String... mappersPackages)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader cl = getClass().getClassLoader();
		for (String mappersPackage : mappersPackages) {
			Set<ClassPath.ClassInfo> classesInPackage = ClassPath.from(cl).getTopLevelClassesRecursive(mappersPackage);
			for (ClassInfo classInPackage : classesInPackage) {
				Class<?> clazz = Class.forName(classInPackage.getName());
				if (Mapper.class.isAssignableFrom(clazz)) {
					mappers.add((Mapper<?, ?>) clazz.newInstance());
				}
			}
		}
	}

	/**
	 * Maps the object of the source to an object of the type destination.
	 * 
	 * @param source
	 *            - object that will be used to map to the destination
	 * @param destination
	 *            - object that will be mapped from the source object
	 * @return The object that was mapped from the source object
	 */
	@SuppressWarnings("unchecked")
	public <T1, T2> T2 map(T1 source, T2 destination) {
		if (mapByName) {
			mapByName(source, destination);
		}
		for (Mapper<?, ?> mapper : mappers) {
			if (mapper.getSourceType() == source.getClass() && mapper.getDestinationType() == destination.getClass()) {
				return ((Mapper<T1, T2>) mapper).map(source, destination);
			}
		}
		LOGGER.log(Level.WARNING, "No mapper found for source class " + source.getClass().getName()
				+ " and destination class " + destination.getClass().getName());
		return null;
	}

	/**
	 * Maps the object of the source to an object of the type destination.
	 * 
	 * @param source
	 *            - object that will be used to map to the destination
	 * @param destinationClass
	 *            - class of the object that will be returned
	 * 
	 * @return The object that was mapped from the source object
	 * 
	 */
	public <T1, T2> T2 map(T1 source, Class<T2> destinationClass) {
		try {
			T2 destination = destinationClass.newInstance();
			return map(source, destination);
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Unable to instantiate object of class " + destinationClass);
			return null;
		}
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
						String sourceFieldName;
						if (m2.getName().startsWith("get") && fieldType.isAssignableFrom(m2.getReturnType())) {
							sourceFieldName = m2.getName().substring(3, m2.getName().length());
						} else if (m2.getName().startsWith("is") && fieldType.isAssignableFrom(m2.getReturnType())) {
							sourceFieldName = m2.getName().substring(2, m2.getName().length());
						} else {
							continue;
						}
						mapField(m2, m1, sourceFieldName, fieldName, source, destination);
						break;
					} catch (Exception e) {
						continue;
					}
				}
			}
		}
	}

	private void mapField(Method sourceMethod, Method destinationMethod, String sourceFieldName,
			String destinationFieldName, Object source, Object destination) throws Exception {
		Method getterMethod = getMethodFromClass(destination.getClass(), "get" + destinationFieldName);
		if (sourceFieldName.equals(destinationFieldName)
				|| (!this.caseSensitive && sourceFieldName.equalsIgnoreCase(destinationFieldName))) {
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
