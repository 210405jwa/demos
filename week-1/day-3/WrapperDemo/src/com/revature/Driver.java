package com.revature;

public class Driver {

	public static void main(String[] args) {
		
		// There is a wrapper class for every primitive in Java
		// It is pretty straightforward what the class name is for each of them
		// for boolean it is Boolean
		// for double it is Double
		// for char it is Character
		// for int it is Integer
		// for long it is Long
		
		// We have this idea of autoboxing and unboxing
		Integer i1 = 100; // autoboxing: the automatic instantiation of a primitive into a corresponding object w/ that value internally
		// same as Integer i1 = new Integer(100);
		
		Integer i2 = 5;
		Integer result = 50 + i2; // i2 is 'unboxed' into a primitive, the two primitives are then added together, and then 
		// the result of the addition is autoboxed into an Integer object, which is then refered to by the Integer result variable
		
		System.out.println(i1 + i2); // i1 and i2 being unboxed, and then added together and printed out
		
		// Each Wrapper class also have convenience properties and methods
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		int a = Integer.parseInt("10");
		int b = Integer.valueOf("10");
		
		Integer b1 = new Integer(10);
		Integer b2 = new Integer(10);
		System.out.println("b1 == b2: " + (b1 == b2));
		System.out.println("b1.equals(b2): " + (b1.equals(b2)));
	}

}
