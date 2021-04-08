package com.revature;

import java.lang.reflect.Field;

public class Driver {

	/*
	 * The Reflection API is a collection of classes in Java that allows us to perform introspection at runtime.
	 * This means we can analyze our program within our program and modify its behavior.
	 */
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// The String Pool is part of the heap
		// String literals will basically become reference variables to String objects that exist in the String pool
		
		// There is a way to interact with the String Pool through the use of the intern() method
		String s = new String("Hello World!");
		s = s.intern(); // intern() returns a reference to the String object inside the string pool, and creates one if it doesn't already
		// exist in the string pool
		
		System.out.println(s == "Hello World!");

		/*
		 * Reflection
		 */
		Class<String> stringClass = String.class;
		
		// This is a handle on the "value" property of a String object
		// I obtained this handle by utilizing the Class class of String
		Field stringValue = stringClass.getDeclaredField("value");
		stringValue.setAccessible(true);
		stringValue.set(s, "HAHAHAHAHA".toCharArray());
		
		System.out.println("HAHAHAHAHA");
		System.out.println("Hello World!");
	}

}
