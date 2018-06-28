package com.yatish.Threads;

/*
 * What does 'wait()' do?
 * It is similar to 'sleep()' but not same as 'sleep()'. once 'wait()' is called, it makes the thread goto sleep but it doesn't resume back after sometime like 'sleep()' a explicit wake up call 
 * is need for 'wait()' to resume back. There are lot of difference between 'sleep' and 'wait' let's see them first to understand the use of 'wait'.
 * 
 * 'wait' method provides few variations as follows,
 * 1) wait()			-->  The thread goes to sleep mode and doesn't wake up on its own at all. it requires a 'notify' or 'notifyAll' call from other threads to wake up and resume back. For now think
 * 						 of 'notify' and 'notifyAll' as like alarm calls to wake up the waiting thread.
 * 2) wait(long milliseconds)	--> We can specify the timeout in milliseconds. after a thread goes to sleep mode, it can be woken up by 'notify' or 'notifyAll' call, if it doesn't get any 'notify'
 * 									or 'notifyAll' call at all, then it will automatically wake up by itself and resumes back once timeout is over.
 * 3) wait(long milliseconds,int nanoseconds)	-->   This is same as the 'wait(long milliseconds)'  we can also specify the 'nano seconds' as well to have very precise control over the timeout.
 * 
 * NOTE: Please refer to the 'J15_1_wait_vs_sleep.java' before continuing further to understand the difference between 'sleep' and 'wait'
 * 
 * 
 * The output of this program is as follows,
		0
		Thread 1 is going to sleep		--> 'o1' has gone to sleep mode using 'wait()' method. 'o1' has not yet resumed and completed the execution of synchronized method, before that already 'o2'
											has entered the synchronized method and starting executing. Hence 'wait()' will revoke the lock it has on synchronized method, hence other thread 'o2'
											acquired the lock and started executing the synchronized method. hence once the 'wait()' method is see by the thread, it will give up its locks hence
											synchronization is lost and it becomes asynchronous.
		0
		Thread 2 is going to sleep

 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * NOTE: Make sure that always wait() and notify() are within synchronized block or locked using locks. If not then they won't work as expected and may result in an exception like 
 * java.lang.IllegalMonitorStateException because, before calling 'wiat()' or 'notify()' we have to acquire lock on that object using synchronized or locks.
 * 
 */
public class J15_wait {

	static P1 obj = new P1();
	public static void main(String[] args) {
		P t1 = new P();
		P t2 = new P();
	
		Thread o1 = new Thread(t1);
		Thread o2 = new Thread(t2);
		o1.setName("Thread 1");
		o2.setName("Thread 2");
		
		o1.start();	
		o2.start();
	}

}

class P implements Runnable {
	public void run() {
		
		J15_2_notify.obj.method();
		
	}
}

class P1 {
	
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

}

