package com.yatish.Threads;

public class J3_extending_Thread {

	public static void main(String[] args) {
		
		A obj = new A();
		/*
		 * We are using both method 'start()' and 'run()' to start a thread. what is the difference between them?
		 * start() method
		 * --------------
		 * 'start()' method is added in 'Thread' class, it is not a method from 'Runnable' interface. 'start()' method will call 'run()' method internally.
		 * The 'start()' method checks if the thread is is proper state to start or not and throws in 'IllegalThreadState' exception. consider you have 'start()' method twice in your code as follows,
		 * 		obj.start();
		 * 		obj.start(); 	--> this will throw 'IllegalThreadState' exception as the thread is already in 'running' state instead of 'new' state.
		 * 'start()' method will create a new thread.
		 * run() method
		 * ------------
		 * 'run()' method is implemented in 'Thread' which is a method from 'Runnable'. whatever we write in 'run()' will be executed on call of 'run()' method.
		 * 'run()' method doesn't create a new thread.
		 * 
		 * 
		 */
		obj.start();		// This will create a new thread, it will create a new call stack.
		obj.run();		// This will not create a new thread. it will use the current Thread(in this case main thread) call stack. here it is main method execution thread. hence there cannot
						//  do context switching as there is no new thread created. hence there is no multi-threading achieved. we have to use '.start()' only to achieve multi-threading. 
						//  It is same as simply calling a function of some class nothing special.
		
	}

}


/*
 * One way of creating threads is by extending the class with 'Thread' class.
 * 
 * Each Thread has a function called 'run()' in which we actually write the logic to be executed by the thread.
 * 
 * We have not defined 'run()' method in 'A' class, but still compiler is not throwing any error!!! ?
 * Actually 'Thread' class has a 'run()' method defined in it which just internally calls 'run()' method. Hence java compiler is not throwing any error.
 */
class A extends Thread{
	
}


/*
 * How do you expect the threads to be executed?
 * We cannot answer that!!!! it is even beyond java. The thread execution and scheduling is carried out by OS. it also depends on number of processors, cores and scheduling algorithms.
 * 
 */

