package com.yatish.Threads;

public class J14_1_isInterrupted {

	/*
	 * What is 'isInterrupted()' method?
	 * It acts as a getter method for 'interrupted' field/property. It simply returns the value of 'interrupted' field/property.
	 * 
	 * NOTE: '.isInterrupted()' is a s non-static method like 'wait()' and 'notify()' method. Hence we have to invoke this method only using current object like 'obj.isInterrupted()' outside the 
	 * 		 thread class and inside the thread class, just write 'isInterrupted()'. 
	 * 
	 */
	public static void main(String[] args) {
			
			M obj = new M();
			obj.interrupt();
			obj.start();
			try {
			obj.interrupt();								// it will just set the 'interrupted' flag to true
			} catch(Exception e) {
				System.out.println("Exception occured while calling interrupt");
			}
			
	
		}

}


class M extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " " + 0);
		
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			System.out.println("The interrupt flag value after calling 'interrupt()' on it  - " + isInterrupted());	// it is printing 'true' since we set it to 'true' in 'obj.interrupt()'
			sleep(2000);																// A exception is thrown, as the 'interrupted' flag is set for current thread 'obj'. after throwing exception, it 
																					// will set the 'interrrupted' flag to 'false'
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		System.out.println("The interrupt flag value after exeception is thrown(after interrupting) it  - " + isInterrupted());	// it is printing 'false'
		
		
		
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			sleep(2000);																// A exception is not thrown here, since once a interrupt is done on this thread when it went to 'sleep' or 'wait'
																					//mode, it will reset it the 'interrupted' flag to 'false' 
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(Thread.currentThread().getName() + " " + 1);
	}
}
