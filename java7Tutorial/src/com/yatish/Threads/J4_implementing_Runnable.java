package com.yatish.Threads;

public class J4_implementing_Runnable {

	public static void main(String[] args) {		
		B obj = new B();
		obj.run();	// this doesn't create a thread. it is same as calling a method in some class.
		
		/*
		 * if you are using 'implementing Runnable' then you have to create a 'Thread' object manually to create a thread as shown in the below code and pass the object of class which is implementing
		 * 'Runnable' as argument.
		 */
		Thread t1 = new Thread(obj);
		t1.start();     // This is how we start a thread in 'Implementing Runnable' way.
		
	}
	
}


/*
 * One more way of creating threads is by implementing 'Runnable' interface on the class.
 * 
 * do we need to define 'run()' method mandatorily here or we can leave it out like we did in 'J3_extending_Thread.java'?
 * We have to mandatorily define the 'run()' method here because we are implementing interface which doesn't have a definition for 'run()'. Hence it is mandatory to define it.
 */
class B implements Runnable {
	
	public void run() {
		
	}
}
