package com.nitin.design.pattern.singleton;

import com.nitin.design.pattern.sinleton.Printer;
import org.junit.Assert;
import org.junit.Test;


public class PrinterTest {

	@Test
	public void testSingleInstance() {
		Printer instance1 = Printer.getInstance();
		Printer instance2 = Printer.getInstance();
		
		Assert.assertTrue(instance1.equals(instance2));
		Assert.assertTrue(instance1 == instance2);
	}
}
