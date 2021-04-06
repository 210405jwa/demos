package com.revature;

import com.revature.model.Engine;

public class Application {

	public static void main(String[] args) {
		Engine i6 = new Engine("I6");

		Car car = new Car("Supra", "Toyota", i6);
		car.drive();
	}

}
