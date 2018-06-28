package com.yatish.Threads;

public class J7_1_Synchronized_Instance_Methods_2 {

	static I1 obj = new I1("obj");
	static I1 obj1 = new I1("obj1");
	public static void main(String[] args) {
		I t1 = new I();
		I t2 = new I();
		
	
		Thread o1 = new Thread(t1);
		Thread o2 = new Thread(t2);
		o1.setName("Thread-1");
		o2.setName("Thread-2");
		
		o1.start();
		o2.start();

	}

}

class I implements Runnable {
	public void run() {
		/*
		 * The output of this program is as follows,
				obj Thread-1 0
				obj Thread-1 is going to sleep
				obj Thread-1 woke up from sleep
				obj Thread-1 1
				obj1 Thread-1 0						--> If you see this line and next one, both are printed from the synchronized method. How come two threads are simultaneously executing a
				obj Thread-2 0							synchronized method. observe 'Thread-1' is executing synchronous method of 'obj' and 'Thread-2' is executing synchronous method of 'obj1'.
														It is not possible for 'Thread-1' and 'Thread-2' to simultaneously execute synchronous method of a single instance/object say 'obj' or 'obj1'.
				obj1 Thread-1 is going to sleep			Hence, if if we put synchronized on non-static method, then synchronization is at object/instance level. In synchronized on non-static method,
				obj Thread-2 is going to sleep			the synchronous method can be executed simultaneously by multiple threads but each thread will be executing them through different
				obj1 Thread-1 woke up from sleep			instances/objects.
				obj1 Thread-1 1
				obj Thread-2 woke up from sleep
				obj Thread-2 1
				obj1 Thread-2 0
				obj1 Thread-2 is going to sleep
				obj1 Thread-2 woke up from sleep
				obj1 Thread-2 1
				
		 * 
		 */
		J7_1_Synchronized_Instance_Methods_2.obj.method();
		J7_1_Synchronized_Instance_Methods_2.obj1.method();
	}
}

class I1 {
	
	String name;
	
	I1(String s) {
		name = s;
	}
	public synchronized void method() {
		System.out.println(name + " " + Thread.currentThread().getName() + " " + 0);
		
		try {
			System.out.println(name + " " + Thread.currentThread().getName() + " is going to sleep");
			Thread.sleep(2000);
			System.out.println(name + " " + Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(name + " " + Thread.currentThread().getName() + " " + 1);
	}
}
