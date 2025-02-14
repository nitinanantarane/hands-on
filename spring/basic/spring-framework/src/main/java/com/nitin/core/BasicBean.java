package com.nitin.core;

public class BasicBean {

	private static long count = 0;
	private final long id = ++count;
	private String name;
	private String type;

	public BasicBean() {
		
	}
	
	public BasicBean(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BasicBean [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
}
