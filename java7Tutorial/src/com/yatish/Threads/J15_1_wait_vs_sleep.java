package com.yatish.Threads;

public class J15_1_wait_vs_sleep {

	/*
	 * wait
	 * ----
	 * we can specify 'wait()' without any parameters.
	 * sleep
	 * -----
	 * we cannot specify 'sleep()' without any parameters. it is mandatory to provide the timeout.
	 * 
	 * wait
	 * ----
	 * Wait is used for asynchronous handling of threads. which we cannot achieve using 'sleep'. we cannot wake up a thread which is sleeping by call of 'sleep' method using 'notify' or 'notifyAll'
	 * methods like how we do for 'wait', it will wake up only once the timeout expires. Hence we can asynchronously invoke sleeping methods based on some condition using 'wait' but cannot with 
	 * 'sleep'
	 * sleep
	 * -----
	 * Doesn't support asynchronous handling of threads. it wakes up only once the timeout expires. Consider if you try to 'notify' or 'notifyAll' a thread which is sleeping using the 'sleep' method,
	 * what will happen? Nothing. it ignores/doesn't recognize those 'notify/notifyAll' and it will wake up once the timeout expires. Haha
	 * 
	 * 
	 * wait
	 * ----
	 * Once the thread goes to the sleep mode using 'wait', it will revoke the locks. hence other threads can grab the lock and enter the synchronized method/block even though the first thread has
	 * not completed the execution of synchronized block completely. 
	 * sleep
	 * -----
	 * Once the thread goes to the sleep mode using 'sleep' method, it will still hold the locks hence other thread cannot grab the lock. 
	 * NOTE: this difference of revoking the lock is explained in the code in 'J15_wait.java'
	 * 
	 */
}
