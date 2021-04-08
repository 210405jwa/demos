package com.revature;

public class Counter {

	private volatile int value;
	
	private Object lock = new Object();
	
	private Object l1 = new Object();
	private Object l2 = new Object();
	
	public Counter() {
		super();
	}
	
	// When you use synchronized inside the method declaration, the lock that a thread can acquire is the object instance itself
	public /*synchronized*/ void increment() {
		
		// We're still using the object instance as the lock object.
		// In this case, any thread that is waiting to enter this block of code, is BLOCKED from doing so, if another thread
		// is already inside executing the code
		// This ensures that only one thread can be incrementing at a time
		synchronized (lock) {
			value++;
		}
		// 1. We first read the value 
		// 2. We then increment 
		// 3. We then write the result back to the variable
	}
	
	public int getValue() {
		return this.value;
	}
	
	
	/*
	 * Deadlock situation example: If one thread is inside method1, and BLOCKED by some other thread that has l2
	 * and another thread is inside method2, and BLOCKED by the above thread that has l1,
	 * then we can't progress and are stuck in a DEADLOCK situation
	 */
	public void method1() {
		synchronized (l1) {
			synchronized(l2) {
				
			}
		}
	}
	
	public void method2() {
		synchronized (l2) {
			synchronized(l1) {
				
			}
		}
	}
	
	/*
	 * Livelock: pretty much the opposite of deadlock, where two or more threads are too eager to give up processing time for
	 * another thread to execute. So nothing gets done either
	 */
	
}
