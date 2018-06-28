package com.yatish.Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * What is DeadLock?
 * Consider, resource A and B are there. Thread one has acquired lock on 'A' and waiting for 'B'. But Thread two has acquired lock on 'B' and waiting for 'A'. Hence Thread one doesn't 
 * leave 'A' for thread two to proceed and Thread two doesn't leave 'B' for thread one to proceed. Hence this state is called deadlock. Both the threads cannot proceed.
 * 
 */
public class J18_DeadLock {

	static S1 obj = new S1();
	
	public static void main(String[] args) {
		S t1 = new S();
		S2 t2 = new S2();
		
	
		Thread o1 = new Thread(t1);
		Thread o2 = new Thread(t2);
		
		
		o1.start();
		o2.start();

	}

}

class S implements Runnable {
	public void run() {
		J18_DeadLock.obj.method();
	}
}

class S2 implements Runnable {
	public void run() {
		J18_DeadLock.obj.method1();
	}
}

class S1 {
	
	int a;
	final Lock lock1 = new ReentrantLock();
	final Lock lock2 = new ReentrantLock();
	
	public void method() {
		try {
			/*
			 * thread 't1' has locked the 'lock1' and went to sleep meanwhile, thread 't2' has locked 'lock2' in 'method1()' and went to sleep. Once both the threads wakes up from sleep,
			 * 't1' is waiting for 'lock2' and 't2' is waiting for 'lock1' hence deadlock has happened and program is stuck.
			 *  
			 */
			lock1.lock();
			Thread.sleep(2000);
			lock2.lock();
		}catch(Exception e) {
			System.out.println("Exception occured");
		}finally {
			lock1.unlock();
			lock2.unlock();
		}	
	}
	
	public void method1() {
		try {
			lock2.lock();
			Thread.sleep(2000);
			lock1.lock();
		}catch(Exception e) {
			System.out.println("Exception occured");
		}finally {
			lock2.unlock();
			lock1.unlock();
		}	
	}
}
