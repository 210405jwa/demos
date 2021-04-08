package com.revature;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {

	private Queue<Integer> buffer;
	
	public Producer(Queue<Integer> buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				synchronized (buffer) {
					int x;
					while(!buffer.offer(x = (new Random()).nextInt(100))) {
						System.out.println("Producer " + super.getName() + " is falling asleep!");
						buffer.wait();
					}
					
					System.out.println("Added a value: " + x);
					
					buffer.notifyAll(); // Wake up any other threads in the WAITING state to transition back to being RUNNABLE
					
					Thread.sleep(1000); // here is an example of transitioning a thread into TIMED_WAITING
					// We're doing this to slow down our producers and consumers on the other class so that we can more easily
					// visualize the process
				}
			}
		} catch(InterruptedException e) {
			System.out.println("Something happened where the thread in the WAITING state was interrupted");
		}
	}
}
