package com.fnmps.java.template.multilayer.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class MapperManagerTest extends TestCase {

	private MapperManager mapperMgr;
	private TestClassSource source;
	private TestClassDestination destination;

	@Before
	public void setUp() {
		// initialize mapper
		List<Mapper<?, ?>> mappers = new ArrayList<Mapper<?, ?>>();
		mappers.add(new TestMapper());
		mapperMgr = new MapperManager(mappers);

		// initialize source
		source = new TestClassSource();
		source.setField1("AField");
		source.setField2(123);
		source.setField3(true);
		source.setField4("anotherField");
	}

	@Test
	public void testBasicMapper() {
		destination = mapperMgr.map(source, TestClassDestination.class);

		Assert.assertNotNull(destination);
		Assert.assertNotNull(destination.getField1());
		Assert.assertEquals(destination.getField1(), source.getField1());
		Assert.assertNull(destination.getField2());
		Assert.assertNull(destination.getField3());
	}

	@Test
	public void testMapByNameMapper() {
		mapperMgr.setMapByName(true);
		destination = mapperMgr.map(source, TestClassDestination.class);

		Assert.assertNotNull(destination);
		Assert.assertNotNull(destination.getField1());
		Assert.assertEquals(destination.getField1(), source.getField1());
		Assert.assertNotNull(destination.getField2());
		Assert.assertEquals(destination.getField2(), source.getField2());
		Assert.assertNull(destination.getField3());
		Assert.assertNotNull(destination.getfIeLd4());
		Assert.assertEquals(destination.getfIeLd4(), source.getField4());
	}
	
	@Test
	public void testCaseSensitiveMapper() {
		mapperMgr.setMapByName(true);
		mapperMgr.setCaseSensitive(true);
		destination = mapperMgr.map(source, TestClassDestination.class);

		Assert.assertNotNull(destination);
		Assert.assertNotNull(destination.getField1());
		Assert.assertEquals(destination.getField1(), source.getField1());
		Assert.assertNotNull(destination.getField2());
		Assert.assertEquals(destination.getField2(), source.getField2());
		Assert.assertNull(destination.getField3());
		Assert.assertNull(destination.getfIeLd4());
	}
	
	@Test
	public void testWithoutOverrideMapper() {
		mapperMgr.setMapByName(true);
		mapperMgr.setOverrideExistingFields(false);
		
		destination = new TestClassDestination();
		destination.setField2(321);
		destination = mapperMgr.map(source, destination);

		Assert.assertNotNull(destination);
		Assert.assertNotNull(destination.getField1());
		Assert.assertEquals(destination.getField1(), source.getField1());
		Assert.assertNotNull(destination.getField2());
		Assert.assertNotEquals(destination.getField2(), source.getField2());
		Assert.assertNull(destination.getField3());
		Assert.assertNotNull(destination.getfIeLd4());
		Assert.assertEquals(destination.getfIeLd4(), source.getField4());
	}
	
	@Test
	public void testWithOverrideMapper() {
		mapperMgr.setMapByName(true);
		mapperMgr.setOverrideExistingFields(true);
		destination = new TestClassDestination();
		destination.setField2(321);
		destination = mapperMgr.map(source, destination);

		Assert.assertNotNull(destination);
		Assert.assertNotNull(destination.getField1());
		Assert.assertEquals(destination.getField1(), source.getField1());
		Assert.assertNotNull(destination.getField2());
		Assert.assertEquals(destination.getField2(), source.getField2());
		Assert.assertNull(destination.getField3());
		Assert.assertNotNull(destination.getfIeLd4());
		Assert.assertEquals(destination.getfIeLd4(), source.getField4());
	}

}

class TestClassSource {
	private String field1;
	private Integer field2;
	private boolean field3;
	private String field4;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public Integer getField2() {
		return field2;
	}

	public void setField2(Integer field2) {
		this.field2 = field2;
	}

	public boolean isField3() {
		return field3;
	}

	public void setField3(boolean field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

}

class TestClassDestination {

	private String field1;
	private Integer field2;
	private String field3;
	private String fIeLd4;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public Integer getField2() {
		return field2;
	}

	public void setField2(Integer field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getfIeLd4() {
		return fIeLd4;
	}

	public void setfIeLd4(String fIeLd4) {
		this.fIeLd4 = fIeLd4;
	}
}

class TestMapper extends Mapper<TestClassSource, TestClassDestination> {

	@Override
	public TestClassDestination map(TestClassSource source, TestClassDestination destination) {
		destination.setField1(source.getField1());
		return destination;
	}
}