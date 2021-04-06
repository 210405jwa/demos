package com.revature;

import com.revature.model.AreaCalculable;
import com.revature.model.Circle;
import com.revature.model.Rectangle;
import com.revature.model.Shape;

public class Main {

	public static void main(String[] args) {
		
		Shape s = new Rectangle(10.5, 10.0);
		
		System.out.println("area: " + s.getArea());
		System.out.println("name: " + s.getName());

		s = new Circle(10);
		System.out.println("area: " + s.getArea());
		System.out.println("name: " + s.getName());
		
		// Interfaces can also serve as types for our reference variables
		AreaCalculable ac = new Circle(20);
		System.out.println(ac.getArea());
		System.out.println(((Shape) ac).getName());
	}

}
