package com.revature;

public class StringDemonstration {

	public static void main(String[] args) {
		
		char[] helloWorld = { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!' };
		String s1 = new String(helloWorld);
		
		System.out.println("s1: " + s1);
		System.out.println(s1.startsWith("Hello"));
		System.out.println(s1.endsWith("World"));

		String s2 = "Hello World!";
		System.out.println("s2: " + s2);
		
		System.out.println("s1 == s2: " + (s1 == s2));
		
		String s3 = "Hello World!";
		
		System.out.println("s2 == s3: " + (s2 == s3));
		
		String s4 = new String(helloWorld);
		
		System.out.println("s1 == s4: " + (s1 == s4));
		
		// ==
		// In the case of primitives, it compares to the see if they have the same value
		// In the case of reference variables, 
		// it compares to see if the two variables point to the same object
		
		// .equals can be used to compare the actual values of the String objects, even if they are
		// different objects from each other in memory
		System.out.println("s1.equals(s4): " + s1.equals(s4));
		
		String s5 = s4.replace('!', ' '); // replace does not change the String object itself
		// it just returns a reference to a new String object
		// Which, in this case, we are assigning to the variable s5
		System.out.println(s4); // Notice this is unchanged and still has the !
		System.out.println(s5); // Notice that this has the ! replaced with ' '. This is a new object
	}

}
