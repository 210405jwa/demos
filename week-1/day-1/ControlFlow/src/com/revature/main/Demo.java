package com.revature.main;

public class Demo {

	public static void main(String[] args) {
		
		// Control Flow
		
		// if
		// if - else
		// while loop
		// do-while loop
		// for loop
		// enhanced for loop (aka the "for each" loop)
		// switch
		
		// try - catch.. a bit different from the rest I would say

		/*
		 * If w/ else statement
		 */
		if (true) {
			System.out.println("It is true");
		} else {
			System.out.println("It is false");
		}
		
		/*
		 * If else chaining
		 * 
		 * Think of this as a series of mutually exclusive code blocks
		 * Only one of these code blocks will ever execute
		 */
		int age = -1;
		if (age < 0) {
			System.out.println("Invalid input");
		} else if (age < 18) {
			System.out.println("You are a minor");
		} else if (age < 45) {
			System.out.println("You are a young adult");
		} else if (age < 65) {
			System.out.println("You are a middle aged adult");
		} else {
			System.out.println("You are of retirement age");
		}
		
		/*
		 * While loop
		 */
		
		int a = 0;
		while (a < 100) {
			System.out.println("a: " + a);
			a++;
		}
		
		/*
		 * Do-while loop
		 * 
		 * Same as while loop, but always guaranteed to execute at least once
		 */
		
		int b = 10; // b is a method scoped variable
		do {
			System.out.println("b: " + b);
		} while(b < 0);
		
		/*
		 * For Loop
		 */
		// declaration statement; termination statement; increment/decrement statement		
		for (int i = 0; i < 100; i = i + 2) { // i is a block scoped variable
			System.out.println(i);
		}
		
		// Traditional way to iterate over a for loop
		int[] intArray = { 10, 20, 30 };
		for(int i = intArray.length - 1; i >= 0; i--) {
			System.out.println("i: " + i + ", intArray[i]: " + intArray[i]);
		}
		
		// For each loop
		for (int element : intArray) {
			System.out.println(element);
		}
		
		/*
		 * Switch Statements
		 */
		int month = 2;
		switch(month) {
		case 1:
			System.out.println("It is January");
			break; // break is used to prevent fall-through
			// sometimes fall-through might be handy. It really depends on what you are coding
			// But in this case, we don't want fall through
		case 2:
			System.out.println("It is February");
			break;
		case 3:
			System.out.println("It is March");
			break;
		default:
			System.out.println("It is not January, February, or March");
		}
		
	}

}
