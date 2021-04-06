package com.revature;

import com.revature.exceptions.NegativeAgeException;

public class Application {

	public static void main(String[] args) {
		
		try {
			ExceptionDemonstration.demo(10);
			// System.exit(0); // This will circumvent the finally block
		} catch (RuntimeException e) {
			System.out.println("caught unchecked exception: " + e);
			return;
		} catch (Exception e) {
			System.out.println("caught checked exception: " + e);
			return;
		} finally {
			System.out.println("Finally block always executes.. unless your JVM just crashes out of nowhere or you run out of memory");
			System.out.println("This is true even if you try to end the method early by returning");
		}
		
		System.out.println("end of main()");
	}

}
