package com.revature;

import java.util.HashSet;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

	public static final int BUFFER_SIZE = 100;
	public static final int NUM_OF_PRODUCERS = 2;
	public static final int NUM_OF_CONSUMERS = 2;
	
	public static void main(String[] args) {
		
		Queue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);
		
		// have our buffer half full
		for (int i = 0; i < BUFFER_SIZE/2; i++) {
			buffer.add((new Random()).nextInt(100));
		}
		
		/*
		 * Create producers
		 */
		Set<Producer> producers = new HashSet<>();
		
		for (int i = 0; i < NUM_OF_PRODUCERS; i++) {
			Producer p = new Producer(buffer);
			producers.add(p);
		}
		
		/*
		 * Create consumers
		 */
		Set<Consumer> consumers = new HashSet<>();
		
		for (int i = 0; i < NUM_OF_CONSUMERS; i++) {
			Consumer c = new Consumer(buffer);
			consumers.add(c);
		}
		
		/*
		 * Start up threads
		 */
		for (Consumer c : consumers) {
			c.start();
		}
		
		for (Producer p : producers) {
			p.start();
		}
	}

}
