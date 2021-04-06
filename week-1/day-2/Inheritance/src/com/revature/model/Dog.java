package com.revature.model;

// Whenever we inherit from another class, we are inheriting its properties and methods (keeping in mind access modifiers)
public class Dog extends Animal {

	public String name;
	
	public Dog() {
		super();
	}
	
	public Dog(String name, String noise, boolean isDomestic) {
		super(noise, isDomestic);
		this.name = name;
	}
	
	public void playFetch() {
		System.out.println(name + " is playing fetch!");
	}
	
	public void bark() {
		System.out.println(name + " is barking: " + super.noise);
	}
	
}
