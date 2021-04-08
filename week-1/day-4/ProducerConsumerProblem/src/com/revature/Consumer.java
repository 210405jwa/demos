package com.revature;

import java.util.Queue;

public class Consumer extends Thread {

	private Queue<Integer> buffer;
	
	public Consumer(Queue<Integer> buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				synchronized(buffer) {
					while(buffer.isEmpty()) {
						System.out.println("Consumer " + super.getName() + " is falling asleep!");
						buffer.wait();
					}
					
					int value = buffer.remove();
					
					System.out.println("Consuming value: " + value);
					
					buffer.notifyAll(); // notifies to producers that may have been waiting due to the buffer being full,
					// that they can wake up because the consumer has consumed a value
					
					Thread.sleep(1000); // here is an example of transitioning a thread into TIMED_WAITING
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Something happened where the thread in the WAITING state was interrupted");
		}
	}
	
}
