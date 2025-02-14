package com.nitin.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicBeanMain {
	

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ApplicationContext context = new ClassPathXmlApplicationContext("basicBean.xml");
		BasicBeanSvc basicBeanSvc = context.getBean("basicBeanSvc", BasicBeanSvc.class);
		
		
		for (int i = 0; i < 10; i++)
		basicBeanSvc.add(BasicBean.class.newInstance());
		
		System.out.println(basicBeanSvc.getAll());
		
		((AbstractApplicationContext) context).close();
		
		
	}
}
