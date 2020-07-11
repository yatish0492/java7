package com.yatish.Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class J9_Join {

	static E1 obj = new E1();
	
	public static void main(String[] args) {
		E t1 = new E();
		E t2 = new E();
		E t3 = new E();
		
	
		Thread o1 = new Thread(t1);
		Thread o2 = new Thread(t2);
		Thread o3 = new Thread(t3);
		
		o1.start();
		
		/*
		 * 'o1.join()' --> This block the execution point here itself(at this statement) until 't1' thread is completed. like how while debugging
		 * 		   until we release the control to next step. So if already we have started any other threads say like 'o2.start()' then 
		 *		   that thread would still run in parallel. Basically it doesn't block any other threads which are running.
		 * 
		 * NOTE: There is one more variation of '.join()' which accepts a parameter(long). '.join(long milliseconds)' in this case the execution point
		 *		is blocked until whichever of the following happens first,
		 *			1) If the thread on which '.join()' is called finishes 
		 *						OR
		 *			2) if the mentioned 'milliseconds' times out.
		 * 
		 * 
		 */
		try {
		o1.join();
		} catch(Exception e) {}
		o2.start();
		o3.start();
	}

}

class E implements Runnable {
	public void run() {
		J9_Join.obj.method();
	}
}

class E1 {
	
	public void method() {
		//final Lock lock = new ReentrantLock();
		//lock.lock();
		System.out.println(0);
		
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(1);
		//lock.unlock();
	}
}
