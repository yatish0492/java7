package com.yatish.Threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class J8_Reentrant_Lock {

	/*
	 * what is the 'ReentrantLock'?
	 * It is the implementation class of 'Lock' interface provided by java in 'java.util.concurrent' package.
	 * 
	 * why do we call this as 'ReentrantLock'?
	 * In 'ReentrantLock' we can call the 'lock()' method multiple times as shown in below example, Hence since we can re-enter the lock() more than once, it is called ReentrantLock.
	 * eg: 	ReentrantLock obj = new ReentrantLock();
	 * 		obj.lock();		--> hold = 1
	 * 		obj.lock();		--> hold = 2
	 * 		.
	 * 		.
	 * 		obj.lock();		--> hold = n
	 * 		obj.unlock();	--> hold = n-1
	 * 		.
	 * 		.
	 * 		obj.unlock();	--> hold = 1
	 * 		obj.unlock();	--> hold = 0
	 * 	As shown in the above example, JVM maintains a variable 'hold', which contains the count of how many times the lock has been acquired. 'hold' increments by 1 whenever 'lock()' is
	 *  invoked and it decrements by 1 whenever 'unlock()' is invoked. Don't think that just a 'unlock()' will release the lock, the lock will be released once the 'hold' value becomes 0
	 *  on call of 'unlock()'
	 *  
	 *  
	 *  Are there any other constructors to create 'ReentrantLock' object?
	 *  Yes!!! There is one parameterized constructor which accepts one parameter 'ReentrantLock(boolean fairness)'.
	 *  eg: 	ReentrantLock obj = new ReentrantLock(true);
	 *  	'fairness' parameter means, 
	 *  if it is set to 'true', then the waiting queue is maintained to make sure that the thread which came first amount the waiting threads to acquire the lock, once the current thread 
	 *  released the lock. Hence the problem 'thread starvation' which we face in 'synchronized' is solved.
	 *  If it is set to 'false', then the waiting queue is not maintained. hence once the current thread releases the lock any thread waiting can acquire the lock. hence the thread which
	 *  came at last also can acquire the lock. hence not fair. Hahaha. 'thread starvation' can happen if it is set to false.
	 *  
	 */
	public static void main(String[] args) {
		ReentrantLock obj = new ReentrantLock();
		
		/*
		 * Is there any way that i want to know the value of 'hold'?
		 * Yes. Java provide a method '.getHoldCount()'. The demo is shown in below code.
		 */
		int holdCount = obj.getHoldCount();
		
		/*
		 * Is there any way to find whether the lock is fair or not?
		 * Yes. Java provides a method '.isFair()'. the demo is shown in below code.
		 */
		boolean isFair = obj.isFair();
		
		/*
		 * Is there any way to find any threads are waiting to acquire this lock or not?
		 * Yes. Java provides a method '.hasQueuedThreads()'. the demo is shown in below code.
		 */
		boolean threadsAreWaiting = obj.hasQueuedThreads();
		
		/*
		 * Is there any way to find how many threads are waiting to acquire this lock?
		 * Yes. Java provides a method '.getQueueLength()'. the demo is shown in below code.
		 */
		int numberOfThreadsWaitingToAcquireLock = obj.getQueueLength();
		
	}

}
