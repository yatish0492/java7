package com.yatish.ProducerConsumer;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * NOTE: Make sure that always wait() and notify() are within synchronized block or locked using locks. If not then they won't work as expected and may result in an exception like 
 * java.lang.IllegalMonitorStateException because, before calling 'wiat()' or 'notify()' we have to acquire lock on that object using synchronized or locks.
 */
public class J2_Producer_Consumer_Without_BlockingQueue {

	public static void main(String[] args) {
		
		final ProducerConsumer obj = new ProducerConsumer();
		
		Thread producerThread = new Thread(new Runnable() {
			public void run() {
				obj.producer();
			}
		});
		
		Thread consumerThread = new Thread(new Runnable() {
			public void run() {
				obj.consumer();
			}
		});
		
		
		
		producerThread.start();
		consumerThread.start();

	}

}


class ProducerConsumer {
	
	Queue<Integer> queue = new PriorityQueue<Integer>();
	int queueCapacity = 10;
	
	public void producer() {		
		int i = 0;
		while(true) {
			synchronized(this) {
				try {
				while(queue.size() == queueCapacity) 
					wait();
		    		queue.add(i++);
		    		notify();
		    			Thread.sleep(1000);
		    		} catch(Exception e) {}
		    		
		    }
		}
	}
	
	public void consumer() {
		while(true) {
			synchronized(this) {
			
				try {
					while(queue.isEmpty()) {
						wait();
					}
					System.out.println(queue.poll());
					
					notify();
					
				} catch(Exception e) {}	
			}
		}
	}
}
