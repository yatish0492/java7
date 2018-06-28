package com.yatish.Threads;

public class J14_interrupt_sleeping_or_waiting {

	/*
	 * what is interrupt?
	 * Interrupt means, don't let a thread to go to sleep or wait state, if it is trying to go also then interrupt it.
	 * 
	 * Thread has a non-static boolean field/property 'interrupted'. this acts as a flag to specify the thread interruted status.
	 * 
	 * Calling '.interrupt()' on the thread object as shown in below code 'obj.interrupt()' will set the flag 'interrupted' to 'true'. so that whenever there is a try to put the thread to sleep/wait
	 * an exception will be thrown.
	 */
	
	public static void main(String[] args) {
		
		K obj = new K();
		obj.start();
		try {
		obj.interrupt();		// This will set the 'interrupted' flag to true for that thread object 'obj'. 
		} catch(Exception e) {
			System.out.println("Exception occured while calling interrupt");
		}
		/*
		 * NOTE: you cannot call wait as 'Thread.wait()' because 'wait()' is a non-static method of 'Thread' class, whereas 'sleep()' is a static method of 'Thread' class. Hence we have to access
		 * them as follows,
		 * 'Thread.wait()' --> Wrong
		 * 'obj.wait()' --> Right
		 * 'obj.sleep(2000)' --> Wrong
		 * 'Thread.sleep(2000)' --> Right
		 */

	}

}


class K extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " " + 0);
		
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			/*
			 * An exception will be thrown as soon as java compiler finds 'Thread.sleep(2000)' or 'wait()' because java compiler will check the 'interrupted' flag of the current thread, 
			 * if it is true, then it will thrown an exception 
			 * if it is false, then it will not throw any exception and let the thread to goto sleep or wait.
			 * 
			 * NOTE: There is no need to call sleep and wait as 'Thread.sleep(2000)' and 'Thread.currentThread.wait()' as we are extending 'Thread' class all these classes like 'sleep' and 'wait'
			 * 		are inherited here. hence we can directly call them using 'sleep(2000)' and 'wait()'
			 */
			sleep(2000);
			wait();
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(Thread.currentThread().getName() + " " + 1);
	}
}


