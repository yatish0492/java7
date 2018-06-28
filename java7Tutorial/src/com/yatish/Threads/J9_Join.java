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
		 * we can achieve what synchronized does using join also.
		 * 
		 * If we can achieve what synchronized does using 'join()' then why the hell do we need 'join()'?
		 * Synchronized can be applied only at method level or at block level. consider you want the threads to be executed sequentially from start to end like once the thread is create by servlet 
		 * handler until that thread returns back the response/dies, then only other thread should start executing. In this case the thread might be executing 100+ methods before dying/returning 
		 * response, how good is it to put synchronized on all those 100+ methods. consider, you are so rude and dumb that you want to put synchronized on all the 100+ methods, then if you want to
		 * execute only one particular thread like this sequentially and for other threads you don't want to execute them sequentially, how will synchronized on all 100+ methods achieve that.
		 * this is where 'join()' comes into picture. 'join()' applies synchronized at the thread level. if we call 'join()' on the thread, then that thread will excuted completely by blocking any
		 * other threads trying to start/execute.
		 * 
		 * NOTE: you have to call 'join' on thread like as shown below 'o1.join();', if have to call join on a thread once you start the thread 'o1' and before any other thread starts like before 
		 * 		'o2.start()'. if it is called before 'o1.start()' or after 'o2.start()'. then it is useless, it doesn't do any synchronization.
		 * 
		 * In this case, since we have called '.join()' on 'o1', first 'o1' will be completely executed while 'o2' and 'o3' will be blocked. once 'o1' completes its execution, 'o2' and 'o3' will 
		 * start executing without any synchronization since we have not called '.join()' on 'o2'.
		 * 
		 * 
		 * NOTE: There is one more variation of '.join()' which accepts a parameter(long). '.join(long milliseconds)' in this case instead of waiting until the thread to finish completely,
		 * 			JVM will execute the thread on which join is called for specified milliseconds by blocking other threads. once the specified milliseconds are 
		 * 			done, then JVM will unblock all the threads hence again all will be executed parallely.
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
