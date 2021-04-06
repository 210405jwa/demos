package com.revature.model;

public class Animal {
	
	protected String noise;
	protected boolean isDomestic;
	
	public Animal() {
		super();
	}
	
	public Animal(String noise, boolean isDomestic) {
		this.noise = noise;
		this.isDomestic = isDomestic;
	}
	
	public void eat() {
		System.out.println("Animal is eating");
	}
	
	public void makeNoise() {
		System.out.println("Animal is making a noise: " + noise);
	}
}
