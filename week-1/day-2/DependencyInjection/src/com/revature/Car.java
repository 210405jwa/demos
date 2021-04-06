package com.revature;

import com.revature.model.Engine;

public class Car {

	public String model;
	public String make;
	public Engine engine;
	
	public Car() {
		super();
	}
	
	public Car(String model, String make, Engine engine) {
		this.model = model;
		this.make = make;
		this.engine = engine; // Injecting an Engine using a constructor
		// Instead of instantiating an engine directly right here
	}
	
	public void drive() {
		engine.startEngine();
		System.out.println("We are now driving...");
	}
	
}
