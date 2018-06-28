package com.yatish.Threads;

public class J5_extendingThread_VS_implementingRunnable {

	/*
	 * extendingThread
	 * ---------------
	 * The 'Thread' class is implementing the 'Runnable' interface and we are extending 'Thread' class.
	 * implementingRunnable
	 * --------------------
	 * we are implementing 'Runnable' interface directly.
	 * extendingThread
	 * ---------------
	 * in this we already extend 'Thread' class hence we cannot extend any other classes even if we want to.
	 * implementingRunnable
	 * --------------------
	 * since we are implementing 'Runnable' interface, we can extend a class as well, which is not possible in 'extendingThread' way.
	 * 
	 * 
	 * 
	 * Which is better way to create threads 'by extending Thread' or 'by implementing Runnable'?
	 * This depends on the developer need.
	 * 		1) If developer wants to extend a class to the thread class, then 'implementingRunnable' is good option. 
	 * 		2) 'extendingThread' is a good option, if developer want to override existing methods in 'Thread' class.
	 *  		3) If developer just want to create thread for just running the 'run()' method in new thread, then better to go for 'implementingRunnable' because many threads can share the 
	 *  				same runnable object instance.'extendingThread' is tightly coupled whereas 'implementingRunnable' is loosely coupled.
	 * 
	 */
}
