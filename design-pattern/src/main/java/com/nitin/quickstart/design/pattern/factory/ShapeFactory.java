package com.nitin.quickstart.design.pattern.factory;

public class ShapeFactory {

	private ShapeFactory () {
		
	}
	
	public static Shape getShape(ShapeType shapeType) {
		Shape shape = null;
		
		switch (shapeType) {
		case CIRCLE: 
			shape = new Circle();
			break;

		case SQUARE:
			shape = new Square();
			break;
			
		case POLYGON:
			shape = new Polygon();
			break;
		default:
			break;
		}
		
		return shape;
	}
}
