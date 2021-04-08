package com.revature;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
		// One of the issues that Generics seeks to solve is "type-safety"
		// In a scenario, imagine Dog and Cat both inherit from Animal
		// I am using an Animal reference variable to point to cat
		// If I try to cast this Animal reference variable to Dog, I will receive a ClassCastException
		// And what it will say is that I cannot cast a Cat to a Dog
		
		// Generics gives us the ability to have types as parameters. This is known as "parameterized types"
		
		// ArrayList is a type of List, which is a type of Collection. It stores elements in order, by index, and can grow
		// or shrink, unlike an Array, which is fixed in size. So an ArrayList solves this issue of fixed size
		ArrayList al = new ArrayList();
		al.add("String 1");
		al.add("String 2");
		al.add(new Integer(10));
		al.add(new Integer(20));
		
		String s = (String) al.get(1); // This is NOT type-safe code, because I have to do some sort of explicit downcast
		System.out.println(s);
		
		ArrayList<String> al2 = new ArrayList<>();
		al2.add("String 1");
		al2.add("String 2");
		
		String s2 = al2.get(1);
		
		GenericClass<Integer> gc = new GenericClass();
		gc.setValue(10);
		Integer value = gc.getValue();
		System.out.println(value);
	}

}
