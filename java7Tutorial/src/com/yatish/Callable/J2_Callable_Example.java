package com.yatish.Callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class J2_Callable_Example {

	public static void main(String[] args) {
		
		/*
		 * We are creating an object of the 'Callable' implementation like how we create object of 'Runnable' implementation.
		 */
		CallableExample obj = new CallableExample();
		
		/*
		 * We have to pass the 'Callable' implementation object into 'FutureTask' constructor so that we get a Future task object of this thread so that we can later the fetch the object returned by
		 * the thread in future.
		 */
		FutureTask randomNumberTasks = new FutureTask(obj);
		
		/*
		 * We pass the 'FutureTask' object while creating thread instead of passing 'Callable' object itself. because 'Thread' object needs to know to which FutureTask, it has to return the object
		 * returned by thread.
		 */
		Thread t = new Thread(randomNumberTasks);
		
		/*
		 * Then we start the thread normally using '.start'
		 */
		t.start();
		
		/*
		 * 'FutureTask' object provides a method 'isDone()' which will return us the status of the thread like whether the thread has completed execution or not.
		 */	
		System.out.println(randomNumberTasks.isDone());
		
		try {
			/*
			 * 'FutureTask' object provides a method 'get()' which will return the value returned by the thread. 
			 * 
			 * Consider, if the thread is not finished it's execution or it has not started yet and we call 'get()' function, then what will happen?
			 * In that case, it will wait until the thread has completed executing and then it will return the value returned by the thread.
			 * 
			 * NOTE: one more advantage with 'Callable' is it can throw an exception and we can catch the exception thrown by thread which is not possible with 'Runnable'.
			 */
			System.out.println(randomNumberTasks.get());
		}catch(Exception e) {}
		
		
		/*
		 * 'FutureTask' object provides a method 'cancel(mayInterupIfRunning)'. It will cancel the task scheduled to run the thread if the thread has not started executing. If the thread has already 
		 * started, then if we are passing 'true' then it will interrupt the thread. if we are passing 'false' then it will not interrupt the thread and allow it to finish up its execution.
		 */
		randomNumberTasks.cancel(true);
		randomNumberTasks.cancel(false);
		

	}

}



/*
 * Same like 'Runnable' we need to implement 'Callable'. But we need to implement 'call' method instead of 'run' method with return type as 'Object' not 'void'
 */
class CallableExample implements Callable
{

	public Object call() throws Exception
	{
		try {
		Thread.sleep(1000);
		}catch(Exception e) {}

		return 3;
	}
}
