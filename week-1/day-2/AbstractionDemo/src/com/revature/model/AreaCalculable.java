package com.revature.model;

public interface AreaCalculable {

	double getArea(); // public abstract is implicit when you define a method inside an interface
	
	double PI = 3.14159; // If I define variables inside my interfaces, they are implicitly public, static, and final
	
	public static void staticMethod() {
		System.out.println("This is a static method inside my interface, AreaCalculable");
	}

}
