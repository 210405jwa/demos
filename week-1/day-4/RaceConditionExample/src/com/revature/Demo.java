package com.revature;

public class Demo {

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		Runnable r = () -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		};
		
		Thread[] threads = new Thread[100];
		// All of our threads will be in the NEW state
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(r);
		}
		
		// All of our threads will be in RUNNABLE once we call start on them
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}

		// Tell the main thread to wait for all of these other threads to finish executing first, before it prints out
		// the value inside the counter object
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Once all 100 threads are done, then we finally print out the value inside of counter.
		// Theoretically, 100 threads should each be incrementing the value by 1000, so we should get a value 100,000
		// But in reality this is not actually happening. In many cases it falls short
		System.out.println(counter.getValue());
		
		// This is what is known as a race condition. The value that we get is fully dependent upon when the thread scheduler
		// is scheduling each thread for processing time.
	}

}
