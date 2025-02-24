package com.thinkinginjava.design.pattern.factory;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class FactoryTest {

	@Test
	public void testShapeFactory() {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));
		
		ShapeFactory.getShape(ShapeType.CIRCLE).draw();
		assertTrue(byteArrayOutputStream.toString().contains("Draw: Circle"));
		
		ShapeFactory.getShape(ShapeType.POLYGON).draw();
		assertTrue(byteArrayOutputStream.toString().contains("Draw: Polygon"));
		
		ShapeFactory.getShape(ShapeType.SQUARE).draw();
		assertTrue(byteArrayOutputStream.toString().contains("Draw: Square"));
	}
}
