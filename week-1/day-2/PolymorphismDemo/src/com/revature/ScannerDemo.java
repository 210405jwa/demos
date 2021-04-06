package com.revature;

import java.util.Scanner;

import com.revature.model.Animal;
import com.revature.model.Cat;
import com.revature.model.Dog;

public class ScannerDemo {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/*
		 * This example is intended to show dynamic behavior through the introduction of user input
		 * 
		 * The user chooses what the variable, Animal a refers to, and then we can therefore see at runtime
		 * Which implementation of makeNoise is being used
		 */
		int choice = 0;
		do {
			System.out.println("Select an Animal: ");
			System.out.println("0.) Exit");
			System.out.println("1.) Dog");
			System.out.println("2.) Cat");
			
			choice = Integer.parseInt(sc.nextLine());
			
			Animal a = null;
			switch (choice) {
				case 0:
					break;
				case 1:
					a = new Dog("Fido");
					break;
				case 2:
					a = new Cat("Whiskers");
					break;
				default: 
					System.out.println("Invalid choice");
			}
			
			if (a != null) {
				a.makeNoise();
			} else {
				if (choice != 0) {
					System.out.println("Did not select an Animal!");
				}
			}
			
		} while (choice != 0);
		
	}
	
	
	// Code is here for reference, we're going to use main for something else now
	public static void simpleScannerDemo() {
		System.out.print("Enter a name: ");
		String name = sc.nextLine();
		System.out.println("Hello, " + name);
		
		System.out.print("Enter an age: ");
		
		// Method 1 of a workaround of the quirks w/ using something like nextInt, nextDouble, etc. followed by a nextLine
//		int age = sc.nextInt();
//		sc.nextLine();
		
		// Method 2 of a workaround
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.println("The age: " + age);
		
		System.out.print("Enter an occupation: ");
		String occupation = sc.nextLine();
		System.out.println("The occupation: " + occupation);
	}

}
