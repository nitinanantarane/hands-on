package com.nitin.quickstart.design.pattern.singleton;

import org.junit.Assert;
import org.junit.Test;

import com.nitin.quickstart.design.pattern.sinleton.Printer;


public class PrinterTest {

	@Test
	public void testSingleInstance() {
		Printer instance1 = Printer.getInstance();
		Printer instance2 = Printer.getInstance();
		
		Assert.assertTrue(instance1.equals(instance2));
		Assert.assertTrue(instance1 == instance2);
	}
}
