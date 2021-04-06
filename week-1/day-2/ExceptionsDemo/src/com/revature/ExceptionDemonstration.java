package com.revature;

import com.revature.exceptions.NegativeAgeException;

public class ExceptionDemonstration {

	/*
	 * method 2: declare the exception: use the throws keyword to indicate that this method throws this exception and needs to be
	 * handled somewhere else
	 */
	public static void demo(int age) throws NegativeAgeException {
		System.out.println("demo() method running");
		
		/*
		 * method 1: handling the exception
		 */
//		try {
//			if (age < 0) {
//				throw new NegativeAgeException("Age must be positive"); // because NegativeAgeException is a checked exception, I must
//				// handle or declare this exception
//			} else {
//				System.out.println("Age is " + age);
//			}
//		} catch (NegativeAgeException e) {
//			System.out.println(e);
//		}
		
		// Throwing an unchecked exception
		if (age > 130) {
			throw new RuntimeException("Age must be 130 or lower");
		}
		
		/*
		 * Method 2
		 */
		if (age < 0) {
			throw new NegativeAgeException("Age must be positive"); // because NegativeAgeException is a checked exception, I must
		} else {
			System.out.println("Age is " + age);
		}
		
		
		
	}
	
}
