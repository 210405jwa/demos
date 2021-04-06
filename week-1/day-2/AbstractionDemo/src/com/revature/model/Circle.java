package com.revature.model;

public class Circle extends Shape {

	private double radius;
	
	public Circle(double radius) {
		super("circle");
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return AreaCalculable.PI * Math.pow(this.radius, 2);
	}

}
