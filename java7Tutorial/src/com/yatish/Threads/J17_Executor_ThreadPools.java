package com.yatish.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * What is ExecutorServie?
 * It is a new framework to handle Threads. ExecutorService framework will create a thread pool first with threads based on the user input parameter in '.newFixedThreadPoo(x)'. Then
 *  we have to provide the 'Runnable' instance to the executor using '.execute' method. The framework will pick any of the threads in the pool and execute it, if there are no threads free
 *  in the pool then it wait for any of the threads to become free and use it to execute the task. Once a thread has finished executing its work, it will goto the pool and rest there or
 *  it will take up any pending/new tasks.
 *  
 *  What is the advantage of ExecutorService, we could have created the threads whenever we want to execute the tasks right?
 *  Creating new threads for each and every time will consume time because create a new thread itself takes some time and resources. In ExecutorService framework, it creates the threads
 *  during executor initialization itself, and the same threads will be recycled and used for different tasks hence better performance and less resource usage.
 *  There will no overhead on the developer also by creating threads managing them etc.
 */
public class J17_Executor_ThreadPools {

	public static void main(String[] args) {
		
		/*
		 * Once we create a thread pool. A thread will be created to manage the thread pool which is called as 'managerial thread'.
		 */
		ExecutorService executor = Executors.newFixedThreadPool(2);
		/*
		 * The '.execute()' method provided by ExecutorService framework will take the 'Runnable' instance but it doesn't mean that it will execute it suddenly. It may start it 
		 * in some time or suddenly and it may run using the threads in the threadPool or it may run it on the current thread(in this case it is main thread). It is left to the sole
		 * discretion of the ExcecutorService Framework. 
		 */
		executor.execute(new R());	
		executor.execute(new R());
		
		/*
		 * This will initiate shutdown  of the 'managerial thread'. There will be no new tasks/Runnable instances accepted once the 'shutdown()' is called. 
		 * NOTE: it doesn't wait for the threads to finish up the execution. it will stop them and shutdown the 'managerial thread'
		 * 
		 */
		executor.shutdown();
		
		/*
		 * Consider, I want the Executor to wait for the threads to finish execution and then shutdown, can i do that?
		 * Yes!!!
		 * ExecutorServie framework provides one more method called as '.awaitTermination(timeout,TimeUnit)'. Once the '.shutdown()' is called, we need to call '.awaitTermination' so that
		 * The Executor will wait until the threads executing finishes up. One catch here is we have to provide the 'timeout' mandatorily, we need to specify the unit of timeout as well.
		 * If all threads running finishes up before the timeout then, the Executor will be shutdown, it doesn't simply wait for the timeout to expire.
		 * If the threads are still running, when the timeout expires then the running threads will be stopped and Executor will be shutdown.
		 */
		try {
			executor.awaitTermination(1,TimeUnit.DAYS);
		} catch(Exception e) {}

	}

}


class R implements Runnable {
	public void run() {
		System.out.println(0);
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(1);
		}
		
	}
