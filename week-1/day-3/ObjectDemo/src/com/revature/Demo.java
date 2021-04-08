package com.revature;

public class Demo {

	public static void main(String[] args) {
		
		Object a = new Object();
		// Overloaded println methods. Same name, different behaviors
		System.out.println(a); // behind the scenes, this method is calling x.toString() and getting the String to be printed out
		System.out.println(a.toString()); // This one is just directly taking the String and printing it out
		
		Person p = new Person("John", "Doe");
		System.out.println(p);
		
		// What does == mean?
		// For reference variables, checks to see if they are pointing to the same instance 
		// For primitives, checks to see if they have the same values
		Person p1 = p;
		System.out.println("p1 == p: " + (p1 == p));

		p1 = new Person("John", "Doe");
		System.out.println("p1 == p: " + (p1 == p));
		
		// By the implementation inside the Object class, .equals works exactly the same as ==
		// It is not until we override .equals, that we can do different things
		// For example, return true if they have the same firstName and lastName
		System.out.println("p1.equals(p): " + p1.equals(p));
	}

}
