package com.revature.model;

public class Dog extends Animal {

	private String name;
	
	public Dog() {
		super();
	}
	
	public Dog(String name) {
		this.name = name;
	}
	
	
	/*
	 * Method Overriding
	 * 
	 * Here we are providing an alternative implementation of makeNoise()
	 * 
	 * Basically, this method implementation will be used instead of the one in Animal if I have specifically a Dog object as my
	 * instance
	 */
	@Override
	public void makeNoise() {
		System.out.println("makeNoise() inside Dog: " + name + " is barking!");
	}
	
}
