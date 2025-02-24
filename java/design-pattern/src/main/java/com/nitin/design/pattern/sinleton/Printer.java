package com.thinkinginjava.design.pattern.sinleton;

public class Printer {

	private static Printer printer = new Printer();
	
	private Printer() {
		
	}
	
	public static Printer getInstance() {
		return printer;
	}
	
}
