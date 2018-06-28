package com.yatish.Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Synchronized is a way of achieving thread safe or to handle concurrency issues.
 * synchronized is a keyword in java.
 * synchronized can be applied on method and block as well.
 * 
 * Consider, if more than one thread are changing the value of shared resource/variable. There can be inconsistancy or concurrency problems as mentioned in 'J6_Problems_With_Threads.java'. To avoid
 * those problems synchronized was one of the solution.
 * 
 * Once a thread 't1' enters a synchronized method or block, java will block any other thread from entering that method or block until the 't1' thread comes out of the method or block. Hence the
 * threads are executed sequentially in synchronized method or block.
 * 
 * In this code, 
 * the output will be as follows,
		0
		Thread 1 is going to sleep
		Thread 1 woke up from sleep
		1
		0
		Thread 2 is going to sleep
		Thread 2 woke up from sleep
		1
 * First thread 't1' has entered the synchronized method 'method()'. java has blocked 't2' from entering 'method()'. 't1' has printed '0' and then went to sleep and then woke up and printed '1'.
 * Then only second thread enters 'method()'.
 * 
 */
public class J7_synchronized_Instance_Methods_1 {

	static C1 obj = new C1();
	public static void main(String[] args) {
		C t1 = new C();
		C t2 = new C();
		
	
		Thread o1 = new Thread(t1);
		Thread o2 = new Thread(t2);
		o1.setName("Thread 1");
		o2.setName("Thread 2");
		
		o1.start();
		o2.start();

	}

}

class C implements Runnable {
	public void run() {
		
		J7_synchronized_Instance_Methods_1.obj.method();
	}
}

class C1 {
	
	public synchronized void method() {
		System.out.println(0);
		
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(1);
	}
}
