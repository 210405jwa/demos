package com.revature.model;

public class Rectangle extends Shape {
	
	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		super("rectangle");
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double getArea() {
		return this.length * this.width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
}
