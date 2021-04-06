package com.revature.main;

import java.util.Arrays;

import com.revature.model.Product;

public class Demo {

	public static void main(String[] args) {
		
		// Variables in Java can either be
		// 1. A primitive
		// 2. A reference type
		
		// Primitive types
		// 1. int (4 bytes, 32 bits)
		// 2. float (32 bits)
		// 3. double (64 bits)
		// 4. char (16 bits)
		// 5. boolean (true/false) (4 bytes, 8 bytes.. depends on the JVM)
		// 6. long (64 bits)
		// 7. byte (8 bit)
		// 8. short (16 bits)
		
		// byte -> short -> char -> int -> long -> float -> double... boolean (off on its own)
		
		byte a = 10;
		byte b, c;
		b = 15;
		System.out.println(b);
		
		short d = 4500; 
		char e = 'e'; // 'e' is a char literal
		char f = 1000;
		int g = 243_000_122;
		long h = 444444444444444444L; // Long literal, postfixed with an L
		float i = 10.3F; // float literals need to be postfixed with an f
		double j = 12.323;
		boolean k = true;
		boolean l = false;
		
		// Typical arithmetic
		// Addition (+)
		// Subtraction (-)
		// Multiplication (*)
		// Division (/)
		// Modulus (%) 4 % 2 -> 0
		
		byte a1 = 10;
		byte a2 = 20;
		
		// Automatic promotion
		// Whenever I have a binary operation, such as adding, subtracting, etc.
		// What happens is if the primitives are less than an int, (byte, short, char)
		// Then it will automatically convert them to an int
		byte a3 = (byte) (a1 + a2);
		
		int b1 = 1003434323;
		byte b2 = (byte) b1; // casting from int to byte (this is an unsafe operation, so you have to
		// do it explicitly) (this is a narrowing conversion)
		System.out.println("b2: " + b2);
		
		b1 = b2; // this is a safe operation (also known as a widening conversion)
		
		double c1 = (5 + 0.0) / 2;
		System.out.println("c1: " + c1);
		
		// Increment / Decrement
		// ++, --
		// x++, x-- <- postfix operators
		// ++x, --x <- prefix operators
		
		int t = 0;
		System.out.println("t++: " + t++);
		System.out.println(t);
		System.out.println("++t: " + ++t);
		
		// Compound assignment operators
		int x = 10;
		x += 2; // increase x by 2, x = x + 2
		x -= 2; // decrease x by 2, x = x - 2
		x /= 2; // x = x / 2
		x *= 2; // x = x * 2
		x %= 2; // x = x % 2
		
		// Look into the difference between statement and expression if you're not already familiar
		
		/*
		 * Why are primitives called primitives?
		 */
		
		// To better understand this idea, it is best to go ahead and move into the concept of objects
		// Objects are more complicated structures that can have
		// 1. Properties
		// 		- Variables belonging to a particular object
		// 			- primitive
		// 			- reference types
		// 2. Behaviors
		// 		- methods (blocks of code that can be invoked and executed)
		
		// Let's go ahead and create our first custom class that will serve as a blueprint for an object
		objectDemo();
		
		System.gc(); // Suggest to the JVM to run garbage collection
		
		System.out.println("Done with objectDemo()");
		
		/*
		 * Arrays
		 */
		
		// Arrays are fixed blocks of memory that have been allocated for variables.
		// In other words, an array is basically a group of variables stored together in a contiguous series of
		// memory
		// Because of this contiguous nature, arrays are fixed in size. Once you instantiate an array, you cannot
		// change its size
		
		// Arrays can be referenced to by some sort of reference variable
		// Arrays also are of a certain primitive or reference variable type themselves
		int[] intArray; // This is a reference variable. Arrays are not primitives, so therefore
		// this intArray variable would be pointing to the location of the array itself
		// Arrays are also objects, stored in the heap
		
		intArray = new int[10]; // I am instantiating an array of size 10. I cannot change the size of this array
		// after I have instantiated it already. It is fixed!
		
		// Elements inside an array are accessed through indexing. The indices start from 0 and go up to 
		// the size of the array minus 1.
		System.out.println("intArray[0]: " + intArray[0]); // by default, the value here will be 0
		
		intArray[1] = 10;
		intArray[5] = 100;
		intArray[3] = 5343;
		
		System.out.println(Arrays.toString(intArray));
		
		Object[] products = new Object[4];
		products[0] = new Product("iPhone", 1200, 0.0625);
		products[1] = new Product("Galaxy S21", 700, 0.0625);
		products[2] = new Product("Beer", 5, 0.15);
		products[3] = "Hello World!";
		
		System.out.println(Arrays.toString(products));
		
		int anotherIntArray[] = { 10, 20, 30 }; // Instantiate an int array with the values of 10, 20, 30 of size 3
		// Syntactic sugar: basically it is just some sort of shorthand way to do something faster when you're coding
		// But it doesn't really change the underlying action / principles that are occurring
	}	
	
	private static void objectDemo() {
		Product p1;
		
		p1 = new Product();
		
		System.out.println(p1.productName); // default value for reference types for object properties is null
		System.out.println(p1.price); // default value for numeric types such as double is 0.0 or 0 depending
		// on if it is floating point or an integral type
		System.out.println(p1.taxRate);
		
		p1.productName = "iPhone";
		p1.price = 1200;
		p1.taxRate = 0.0625;
		
		System.out.println("p1 total price including tax: " + p1.getTotalPrice());
		
		Product p2 = new Product("Galaxy S21", 700, 0.0625);
		System.out.println("=== p2 ===");
		System.out.println(p2.price);
		System.out.println(p2.productName);
		System.out.println(p2.taxRate);
		
		System.out.println("p2 total price including tax: " + p2.getTotalPrice());
	}

}
