package com.revature;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Create an application that asks for you to enter a number n
		// And then the application will print out the result of the n-th fibonacci number
		long choice = 0;
		do {
			System.out.println("Enter a number n to calculate the n-th fibonacci: ");
			choice = Long.parseLong(sc.nextLine());
			
			if (choice != 0) {
				long x = choice;
				Runnable r = () -> {
					System.out.println(x + " fib is " + getNthFib(x));
				};
				(new Thread(r)).start();
			}
			
		} while (choice != 0);
		
	}
	
	public static long getNthFib(long n) {
		// O(2^n)
//		if (n == 0) return 0;
//		if (n == 1) return 1;
//		if (n == 2) return 1;
//		
//		return getNthFib(n - 2) + getNthFib(n - 1);
		Map<Long, Long> memoize = new HashMap<>();
		memoize.put(1L, 1L);
		memoize.put(2L, 1L);
		return getNthFib(n, memoize);
	}
	
	public static long getNthFib(long n, Map<Long, Long> memoize) {
		if (memoize.containsKey(n)) {
			return memoize.get(n);
		} else {
			memoize.put(n, getNthFib(n - 1, memoize) + getNthFib(n - 2, memoize));
			return memoize.get(n);
		}
	}
	
	public static void waysToCreateAndStartThreads() {
		// Whenever I run my application, it is basically single threaded, by default.
		// I can see the name of this thread by doing...
		System.out.println(Thread.currentThread().getName());
		
		// The name of the main thread of our program is main. This is the initial thread spun up whenever we execute our program
		// We can create other threads, and have them run concurrently with our main thread.
		// There are 2 classical ways of creating and running threads.
		
		// #1: we can implement Runnable for a certain class, we can then provide an implementation for the run() method
		// and then create a new Thread object, passing in this Runnable into the constructor. 
		// Then call .start() on our Thread object.
		Runnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable);
		t1.start();
		Thread t2 = new Thread(myRunnable);
		t2.start();
		Thread t3 = new Thread(myRunnable);
		t3.start();
		
		// Runnable is a functional interface, so I can just use lambdas instead.
		Thread th1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
		});
		th1.start();
		
		// #2: We can extend the Thread class, and then override run()
		MyClass myThread = new MyClass();
		myThread.start();
	}

}
