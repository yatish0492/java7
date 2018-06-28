package com.yatish.Threads;

import java.util.concurrent.locks.ReentrantLock;

public class J15_4_Alternate_Thread {

	public static void main(String[] args) {
		
		final Alternate obj = new Alternate();
		
		Runnable thread1 = new Runnable() {
			public void run() {
				obj.printEven();
			}
		};
		
		Runnable thread2 = new Runnable() {
			public void run() {
				obj.printOdd();
			}
		};
		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		
		t1.start();
		t2.start();

	}

}


class Alternate {
	
	//private boolean signalled;
	//ReentrantLock lock = new ReentrantLock();
	
	public void printEven() {
		synchronized(this) {
			for(int i = 0; i < 100; i=i+2) {
				System.out.println(i);
				try {
					wait();
					notify();
				}catch(Exception e) {}
			}
		}
	}
	
	public void printOdd() {
		synchronized(this) {
			for(int i = 1; i < 100; i=i+2) {
				System.out.println(i);
				try {		
					notify();
					wait();
				}catch(Exception e) {}
			}
		}
	}
}
