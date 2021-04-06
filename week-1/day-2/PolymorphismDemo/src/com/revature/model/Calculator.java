package com.revature.model;

public class Calculator {

	/*
	 * Method Overloading example
	 * 
	 * It is already determined which method will execute no matter what whenever I compile my code. The compiler takes my source code,
	 * optimizes it, and provides to the JVM the proper "execution path" for a particular method invocation.
	 * 
	 * That's why method overloading is compile-time
	 */
	public int add(int x, int y) {
		return x + y;
	}
	
	public double add(double x, double y) {
		return x + y;
	}
	
}
