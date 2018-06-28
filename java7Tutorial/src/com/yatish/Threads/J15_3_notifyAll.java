package com.yatish.Threads;

public class J15_3_notifyAll {

	/*
	 * Notify vs NotifyAll
	 * --------------------
	 * notify() wakes up the first thread that called wait() on the same object. notifyAll() wakes up all the threads that called wait() on the same object.
	 */
	static Q1 obj = new Q1();
	public static void main(String[] args) {
		Q t1 = new Q();
		Q t2 = new Q();
		Q2 t3 = new Q2();
		
	
		Thread o1 = new Thread(t1);
		Thread o2 = new Thread(t2);
		Thread o3 = new Thread(t3);
		o1.setName("Thread 1");
		o2.setName("Thread 2");
		o3.setName("Thread 3");
		
		o1.start();	
		o2.start();
		o3.start();
	}

}

class Q implements Runnable {
	public void run() {
		
		J15_3_notifyAll.obj.method();
		
	}
}

class Q2 implements Runnable {
	public void run() {
		J15_3_notifyAll.obj.method1();
	}
}

class Q1 {
	
	public  void method() {
		synchronized(this) {
		System.out.println(0);
		
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			wait();
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(1);
		}
	}
	
	public synchronized void method1() {
		try {
		Thread.sleep(2000);
		}catch(Exception e) {
			
		}

		notify();
	}
}

class Q3 {
	public  void method() {
		synchronized(this) {
		System.out.println(3);
		
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			wait();
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(4);
		}
	}
	
}
