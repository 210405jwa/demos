package com.revature;

public class ReverseAString {

	public static void main(String[] args) {
		String s = "Hello World!";
		
		long startingTime = System.nanoTime();
		String reversed = reverseStringWithConcatenation(s);
		long endingTime = System.nanoTime();
		
		System.out.println("String was reversed using concatenation in " + (endingTime - startingTime) + " ns");
		
	}
	
	public static String reverseStringWithConcatenation(String s) {
		String startingString = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			startingString += s.charAt(i); // What String concatenation will do is construct
			// a new string object each and every time, and have startingString point to that new object
		}
		
		return startingString;
	}
	
	public static String reverseStringWithStringBuilder(String s) {
		// Provide your implementation
		return "";
	}
	
	public static String reverseStringWithStringBuffer(String s) {
		// Provide your implementation
		return "";
	}

}
