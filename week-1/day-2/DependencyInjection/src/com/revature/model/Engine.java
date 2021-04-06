package com.revature.model;

public class Engine {

	public String displacement;
	
	public Engine() {
		super();
	}
	
	public Engine(String displacement) {
		this.displacement = displacement;
	}
	
	public void startEngine() {
		System.out.println("Engine with displacement " + displacement + " is starting");
	}
	
}
