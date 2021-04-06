package com.revature.model;

// The abstract keyword makes this Shape class an abstract class
public abstract class Shape implements AreaCalculable {

	private String name;
	
	public Shape(String name) {
		this.name = name;
	}
	
	// Behind the scenes, the abstract class Shape is "overriding" getArea from the interface
	// Not needed, because the below code is implicitly included
//	@Override
//	public abstract double getArea();
	
	public String getName() {
		return this.name;
	}
}
