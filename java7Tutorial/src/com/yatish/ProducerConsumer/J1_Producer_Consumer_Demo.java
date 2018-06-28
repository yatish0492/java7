package com.yatish.ProducerConsumer;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class J1_Producer_Consumer_Demo {

	/*
	 * whey are we explicitly using 'BlockingQueue' here, we could have used other Queue also right?
	 * No!!!!
	 * 'BlockingQueue' has one method called '.take()' which will returns and removes the head element in the queue. most importantly it will wait for the element if it is not there
	 * in the queue. Hence waiting feature is the main thing we want in 'Produce consumer' model.
	 */
	public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1000);
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				producer();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				consumer();
			}
		});
		
		t1.start();
		t2.start();
		
	}
	
	
	public static void producer() {
		//Random random = new Random();
		for(int i = 0; i < 1000; i++) {
			queue.add(i);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
	}
	
	public static void consumer() {
		while(true) {
			try {
				System.out.println("The consumer has taken the value from producer - " + queue.take());
			} catch(Exception e) {}
		}
	}

}
