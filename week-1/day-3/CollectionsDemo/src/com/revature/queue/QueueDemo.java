package com.revature.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.revature.set.Car;

public class QueueDemo {

	public static void demo() {
		Queue<String> linkedListQueue = new LinkedList<>();
		
		linkedListQueue.add("1st Person");
		linkedListQueue.add("2nd Person");
		linkedListQueue.add("3rd Person");
		
		while(!linkedListQueue.isEmpty()) {
			System.out.println(linkedListQueue.poll());
		}
		
		// Change to priority queue implementation
		Queue<String> priorityQueue = new PriorityQueue<>();
		priorityQueue.add("b");
		priorityQueue.add("c");
		priorityQueue.add("a");
		
		// Even though a comes in last, a comes out first, because a has priority over the other elements
		// and is able to "cut" in line
		while(!priorityQueue.isEmpty()) {
			System.out.println(priorityQueue.poll());
		}
		
		// So, I can apply this concept to my Car example, based on what the logic is for my compareTo method that is required
		// to be implemented by the Comparable interface
		Queue<Car> priorityQueue2 = new PriorityQueue<>();
		priorityQueue2.add(new Car(2020, "BMW", "3 series"));
		priorityQueue2.add(new Car(2010, "Hyundai", "Genesis Coupe"));
		priorityQueue2.add(new Car(2019, "Kia", "Stinger GT"));
		
		while(!priorityQueue2.isEmpty()) {
			System.out.println(priorityQueue2.poll());
		}
	}
	
}
