package com.revature.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void demo() {
		
		// In the case of a HashSet, there is no ordering of elements
		// It is unpredictable for the most part
		// The reason we would want to use a Set is to ensure that we have unique elements
		Set<String> fruits = new HashSet<>();
		
		fruits.add("Peaches");
		fruits.add("Apples");
		System.out.println(fruits.add(new String("Peaches"))); // we already have Peaches, therefore this will not be added
		
		Set<Car> carCatalogue = new HashSet<>();
		
		carCatalogue.add(new Car(2020, "BMW", "3 series"));
		carCatalogue.add(new Car(2010, "Hyundai", "Genesis Coupe"));
		carCatalogue.add(new Car(2019, "Kia", "Stinger GT"));
		boolean result = carCatalogue.add(new Car(2019, "Kia", "Stinger GT")); // By default, my HashSet really has 
		// no idea what I mean by duplicate. So, if I wanted to prevent this car from being added, because there is already
		// another car like that in my set, then I need to override the .equals and .hashCode
		System.out.println(result);
		
		for (String s : fruits) {
			System.out.println(s);
		}
		
		for (Car c : carCatalogue) {
			System.out.println(c);
		}
		
		System.out.println(carCatalogue);
		
		/*
		 * TreeSet: a TreeSet actually maintains order
		 * It does this through the fact that the objects being stored in the TreeSet will be implementing something like 
		 * Comparable, or we might also pass in a Comparator when constructing our TreeSet
		 */
		Set<Car> ts = new TreeSet<>();
		ts.add(new Car(2020, "BMW", "3 series"));
		ts.add(new Car(2010, "Hyundai", "Genesis Coupe"));
		ts.add(new Car(2019, "Kia", "Stinger GT"));
		
		System.out.println(ts.add(new Car(2010, "BMW", "5 series")));
		
		System.out.println("ts: " + ts);
		
		for (Car c : ts) {
			System.out.println(c);
		}
	}
	
}
