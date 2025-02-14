package com.nitin.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicBeanSvcImplTest {

	private ApplicationContext context;
	private BasicBeanSvc basicBeanSvc;
	
	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("basicBean.xml");
		basicBeanSvc = context.getBean(BasicBeanSvc.class);
	}
	
	@After
	public void tearDown() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<BasicBean> basicBeanClass = BasicBean.class;
		Field countField = basicBeanClass.getDeclaredField("count");
		countField.setAccessible(true);
		countField.set(null, 0);
		
		((AbstractApplicationContext) context).close();
	}
	
	@Test
	public void testAdd() throws InstantiationException, IllegalAccessException {
		basicBeanSvc.add(BasicBean.class.newInstance());
		
		BasicBean basicBean = basicBeanSvc.get(1L);
		assertNotNull(basicBean);
		assertTrue(basicBean.getId() == 1L);
		
	}
	
	@Test
	public void testUpdate() throws InstantiationException, IllegalAccessException {
		basicBeanSvc.add(BasicBean.class.newInstance());
		
		BasicBean basicBean = basicBeanSvc.get(1L);
		assertNotNull(basicBean);
		assertTrue(basicBean.getId() == 1L);
		assertNull(basicBean.getName());
		assertNull(basicBean.getType());
		
		basicBean.setName("Name123");
		basicBean.setType("Type123");
		basicBeanSvc.update(basicBean);
		
		basicBean = basicBeanSvc.get(1L);
		assertNotNull(basicBean);
		assertEquals(1L, basicBean.getId());
		assertEquals("Name123", basicBean.getName());
		assertEquals("Type123", basicBean.getType());
	}

	@Test
	public void testDelete() throws InstantiationException, IllegalAccessException {
		basicBeanSvc.add(BasicBean.class.newInstance());
		
		BasicBean basicBean = basicBeanSvc.get(1L);
		assertNotNull(basicBean);
		assertTrue(basicBean.getId() == 1L);
		
		List<BasicBean> basicBeanList = basicBeanSvc.getAll();
		assertTrue(basicBeanList.size() == 1);
		basicBeanSvc.delete(basicBean.getId());
		basicBeanList = basicBeanSvc.getAll();
		assertTrue(basicBeanList.size() == 0);
	}
	
}
