package com.yatish.Threads;

import java.util.concurrent.locks.Lock; 
import java.util.concurrent.locks.ReentrantLock;

/*
 * Lock is an interface which has following methods. 
 * 1) lock() --> This method will acquire the lock
 * 2) unlock() --> This method will release the lock
 * 3) tryLock() --> This will just try to acquire lock
 * 4) lockInterruptibly()
 * 5) tryLock(timeInterval,unitOfInterval) 
 * 
 */

/*
 * We had Synchronized right, then whey do we need Reentrant locks?
 * Problem
 * -------
 * In synchronized, it doesn't maintain the waiting queue. that means consider, there are 5 threads 't1','t2','t3','t4','t5' trying to execute a method which is synchronized. 't1' enters method, 
 * until it comes out of the synchronized method, all other threads are blocked. 't2' tried to enter the method 2nd and then 't3' and then 't4' and then 't5'. once 't1' comes out of synchronized
 * method there is no garuantee that 't2' will enter the method, 't5' can also enter(any blocked thread). Where is the justice!!!!!! Actually 't2' should be entering next. HAHAHA. this is the problem
 * with synchronized. it doesn't maintain a waiting queue blocked threads 't2' to 't5' hence without a queue java also cannot know which thread came first. One one problem that could happen is a
 * thread or set of threads may be overtaken by other threads always so those threads doesn't execute at all.
 * Solution
 * --------
 * Reentrant locks. this will maintain a waiting queue.
 * NOTE: you need to pass 'true' in the constructor to maintain the waiting queue.
 */
public class J8_Lock {

	static D1 obj = new D1();
	
	public static void main(String[] args) {
		D t1 = new D();
		D t2 = new D();
		
	
		Thread o1 = new Thread(t1);
		Thread o2 = new Thread(t2);
		
		
		o1.start();
		o2.start();

	}

}

class D implements Runnable {
	public void run() {
		J8_Lock.obj.method();
	}
}

class D1 {
	
	int a;
	final Lock lock = new ReentrantLock();
	
	public void method() {
		lock.lock();
		try {
			System.out.println(0);
			Thread.sleep(2000);
			System.out.println(1);
		}catch(Exception e) {
			System.out.println("Exception occured");
		}finally {
			lock.unlock();
		}
		
		
		
	}
}
