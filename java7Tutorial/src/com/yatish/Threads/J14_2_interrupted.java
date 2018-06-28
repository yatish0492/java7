package com.yatish.Threads;

public class J14_2_interrupted {

public static void main(String[] args) {
		/*
		 * what does 'interrupted()' method do?
		 * 'interrupted()' method will return the 'isInterrupted' field/property value and sets it to false. This will do that same functionality as that of 'isInterrupted()' plus at last it will
		 * reset the value of 'interrupted' field/property to 'false'
		 * 
		 * NOTE: '.interrupted()' is a s static method like 'sleep' method. Hence we have to invoke this method only using 'Thread' class like  'Thread.interrupted()' outside the 
	 		 thread class and inside the thread class, just write 'interrupted()'. 
		 */
		N obj = new N();
		obj.start();
		
		try {
		obj.interrupt();
		} catch(Exception e) {
			System.out.println("Exception occured while calling interrupt");
		}
		
	}

}


class N extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " " + 0);
		System.out.println("The interrupt flat value before calling 'interrupt()' on it  - " + isInterrupted());		// prints 'true' as the 'obj.interrupt()' has set the 'interrupted' flag.
		interrupted();		// reset the 'interrupted' flag to 'false'
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			System.out.println("The interrupt flat value after calling 'interrupt()' on it  - " + isInterrupted());	// prints 'false' as the 'interrupted()'  method has reset it to 'false'
			Thread.sleep(2000);		// exception not thrown because interrupted flag is set to false. by interrupted()
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		System.out.println(Thread.currentThread().getName() + " " + 1);
		
	}
}