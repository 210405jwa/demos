package com.revature;

public class MyClass extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}
