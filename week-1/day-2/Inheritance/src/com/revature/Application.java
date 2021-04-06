package com.revature;

import com.revature.model.Animal;
import com.revature.model.Cat;
import com.revature.model.Dog;

public class Application {

	public static void main(String[] args) {
		
		Dog d = new Dog("Fido", "yip", true);
		d.makeNoise();
		d.bark();
		d.eat();
		d.playFetch();
		
		// This is an example of upcasting, which is implicit
		// I don't need to upcast explicitly
		Animal a = d; // the Animal reference variable will be pointing to the same object as d
		// However, a and d are different types.
		// The limitation of using the Animal reference variable here is that it doesn't have access to the more specific methods
		// and possibly properties of the Dog class
		a.makeNoise();
		a.eat();
		
		// Downcasting
		// You need to downcast explicitly, because it is not a safe operation
		((Dog) a).playFetch();
		((Dog) a).bark();
		
		a = new Cat();
		((Cat) a).consumeCatnip();
		
		((Dog) a).bark(); // Will throw an exception
	}

}
