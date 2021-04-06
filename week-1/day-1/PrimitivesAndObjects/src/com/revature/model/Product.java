package com.revature.model;

public class Product {

	public static int numOfInstances;
	
	public String productName; // Because Strings are not objects, this variable is a reference variable
	// that will actually at some point, POINT to a String object somewhere else
	public double price; // This is a primitive variable, and therefore at some point will have an actual value
	// stored inside this variable
	public double taxRate;
	
	// Default no-args constructor
	// This is a constructor that is already inside my class (implicitly)
	// As soon as I define my own constructor, this default no-args will not be included
	public Product() {
		super();
	}
	
	// Here I am defining a constructor
	// A constructor is a "subroutine" that is used to instantiate an object
	// You typically can populate properties at the time of instantiation inside a constructor
	public Product(String productName, double price, double taxRate) {
		
		
		// Variable shadowing
		// the local variable, productName, is shadowing my instance variable, productName
		// so instead of doing productName = productName, I do this.productName = productName;
		
		this(productName, price); // Constructor chaining
		this.taxRate = taxRate;
	}
	
	public Product(String productName, double price) {
		this(productName); // EITHER super or this is the first line of any constructor
		
		// This keyword
		// "this" is used to refer to "this particular object"
		this.price = price;
	}
	
	public Product(String productName) {
		super(); // super is a call to the parent constructor. In this, the parent's no-args constructor

		this.productName = productName;
	}
	
	/*
	 * Behaviors
	 */
	public double getTotalPrice() {
		return (1 + taxRate) * price;
	}
	
}
