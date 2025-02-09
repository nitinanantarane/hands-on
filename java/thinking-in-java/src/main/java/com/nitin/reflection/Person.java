package com.nitin.reflection;

import java.lang.reflect.Method;

public class Person {

	private String fname;
	private String lname;
	private int age;
	
	public Person() {
		
	}
	
	public Person(String fname, String lname, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<Person> clazz = Person.class;
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.newInstance());
		
		System.out.println("=======================================================");
		
		ClassLoader classLoader = clazz.getClassLoader();
		Class<?> loadClass = classLoader.loadClass("com.nitin.reflection.Person");
		System.out.println(loadClass.getName());
		System.out.println(loadClass.newInstance());
	
		loadClass = classLoader.loadClass("com.nitin.reflection.Person");
		System.out.println(loadClass.getName());
		System.out.println(loadClass.newInstance());
	
		System.out.println("=======================================================");
	
		Method[] methods = loadClass.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
}
