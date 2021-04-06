package com.revature;

import com.revature.model.AnotherClass;

public class Scope {

	/*
	 * Define properties
	 * 		- properties w/ static keyword
	 *		- properties without static keyword
	 */		
	public static int numOfInstances; // static scoped
	public int price; // instance scoped
	
	public Scope() {
		numOfInstances++;
	}
	
	public static void main(String[] args) {
		int x; // method scoped
		x = 100;
		
		if (true) {
			int y; // block scoped
			y = 10;
			System.out.println("y: " + y);
			System.out.println(x);
		}
		
		for(int i = 0; i < 10; i++) {
			
		}
		
		for (int i = 0; i < 100; i++) {
			
		}
		
		// standalone block
		{
			int z = 20;
		}

		
		Scope s1 = new Scope();
		System.out.println("s.price: " + s1.price);
		System.out.println("s.getPrice(): " + s1.getPrice());
		
		Scope s2 = new Scope();
		System.out.println("s.price: " + s2.price);
		System.out.println("s.getPrice(): " + s2.getPrice());
		
		// We are inside a static method called main
		// Static methods can access static variables directly, but not instance variables without an instance
		System.out.println("numOfInstances: " + numOfInstances);
		
		// You can also access static members from referencing the class itself, and then typing out the property or method name
		System.out.println(Scope.numOfInstances);
		
		// You can access static variables from objects, but in reality a static variable has only one
		// copy
		System.out.println(s1.numOfInstances);
		System.out.println(s2.numOfInstances);
		
		AnotherClass.someStaticVariable = 100;
		System.out.println("AnotherClass.someStaticVariable: " + AnotherClass.someStaticVariable);
		AnotherClass.someStaticMethod();
		
		AnotherClass ac = new AnotherClass();
		ac.someInstanceMethod();
	}
	
	public int getPrice() {
		// Instance methods can access instance scoped variables directly
		return price;
	}

}
