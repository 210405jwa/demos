package com.revature;

import com.revature.model.Animal;
import com.revature.model.Calculator;
import com.revature.model.Dog;

public class Application {

	public static void main(String[] args) {
		
		/*
		 * Method Overloading
		 */
		
		Calculator calc = new Calculator();
		
		calc.add(1, 2);
		calc.add(1.0, 2);
		
		int x = 10;
		int y = 20;
		
		calc.add(x, y);
		
		double a = 1.0;
		int b = 1;
		
		calc.add(a, b);

		/*
		 * Method Overriding
		 */
		Animal a1;
		a1 = new Animal();
		a1.makeNoise();
		
		a1 = new Dog("Fido");
		a1.makeNoise(); // Notice how it is using the implementation inside the Dog class even though I am using a1, which is 
		// an Animal reference variable
		
		// This is the power of Method Overriding (runtime polymorphism). It determines at runtime to utilize the overridden implementation
		// Because what object the reference variable can point to changes at runtime.
	}

}
