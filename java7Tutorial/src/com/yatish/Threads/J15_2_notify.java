package com.yatish.Threads;

/*
 * What are 'wait()' and 'notify()'?
 * There are the methods provided by java for communication between threads. like consider you want to communicate from one thread to other thread, in those cases java provides few methods, 'wait()'
 * 'notify()' are one among them.
 * 
 * What does 'notify()' do?
 * A thread gives up the locks and goes to the sleeping mode by calling 'wait()' method. If we call 'notify()' on the same instance from other thread, then the old thread which was sleeping will be
 * woken up by this 'notify()' call and resumes to execute the remaining statements.
 * eg: The output of this porgram is as follows,
 		0
		3
		Thread 3 is going to sleep	--> 'o3' of Runnable instance 'O4' has gone to wait state
		Thread 1 is going to sleep	--> 'o1' of Runnable instance 'O' has gone to wait state
		Thread 1 woke up from sleep	--> On call of 'notify()' in 'o2','o1' has been woken up from wait state.
		1
									--> On call of 'notify()' in 'o2', 'o3' has not been woken up from wait state. Hence the 'notify()/notifyAll()' call will be sent to the threads of same 
										class. in this case, 'o1' and 'o2' threads are of Runnable instance which used same class 'O1'. it is irrespective of objects, like if there is one more 
										thread in wait state which is using another object of class 'O1', that thread will also be notified.
 *  	
 * 
 * NOTE: on call of 'notify()', the awaken waiting thread will acquire the lock.
 * 
 * What is notifyAll()?
 * Consider there 5 threads in wait state, if we call 'notify()', it will wake up any one among the waiting threads. Instead if we call 'notifyAll()', then it will wake up all the threads in wait 
 * state, all of them will try to acquire the lock and any one of them will succeed. If we have only one thread in wait state, in this case using 'notify()' or 'notifyAll()' doesn't make any 
 * difference at all
 * 
 * 
 * 
 * Does calling 'wait()' 5 times require 5 'notify()' to wake it up?
 * No. if we call wait 1 time or 1000 times also, it is same. It will wake up by just calling 'notify' once.
 * 
 */
public class J15_2_notify {

	static O1 obj = new O1();
	static O3 obj1 = new O3();
	public static void main(String[] args) {
		O t1 = new O();
		O2 t2 = new O2();
		O4 t3 = new O4();
		
	
		Thread o1 = new Thread(t1);
		Thread o2 = new Thread(t2);
		Thread o3 = new Thread(t3);
		o1.setName("Thread 1");
		o2.setName("Thread 2");
		o3.setName("Thread 3");
		
		o1.start();	
		o2.start();
		o3.start();
	}

}

class O implements Runnable {
	public void run() {
		
		J15_2_notify.obj.method();
		
	}
}

class O2 implements Runnable {
	public void run() {
		J15_2_notify.obj.method1();
	}
}

class O4 implements Runnable {
	public void run() {
		J15_2_notify.obj1.method();
	}
}

class O1 {
	
	public  void method() {
		synchronized(this) {
		System.out.println(0);
		
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			wait();
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(1);
		}
	}
	
	public synchronized void method1() {
		try {
		Thread.sleep(2000);
		}catch(Exception e) {
			
		}

		notify();
	}
}

class O3 {
	public  void method() {
		synchronized(this) {
		System.out.println(3);
		
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			wait();
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(4);
		}
	}
	
}
