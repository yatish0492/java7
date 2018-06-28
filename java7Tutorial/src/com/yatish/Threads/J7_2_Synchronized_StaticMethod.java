package com.yatish.Threads;

public class J7_2_Synchronized_StaticMethod {

	public static void main(String[] args) {
		J t1 = new J();
		J t2 = new J();
		
	
		Thread o1 = new Thread(t1);
		Thread o2 = new Thread(t2);
		o1.setName("Thread-1");
		o2.setName("Thread-2");
		
		o1.start();
		o2.start();

	}

}

class J implements Runnable {
	public void run() {
		/*
		 * The output of this program is as follows,
				Thread-1 0
				Thread-1 is going to sleep
				Thread-1 woke up from sleep
				Thread-1 1
				Thread-1 0
				Thread-1 is going to sleep
				Thread-1 woke up from sleep
				Thread-1 1
				Thread-2 0
				Thread-2 is going to sleep
				Thread-2 woke up from sleep
				Thread-2 1
				Thread-2 0
				Thread-2 is going to sleep
				Thread-2 woke up from sleep
				Thread-2 1

			In 'J7_1_Synchronized_Instance_Methods_2' you saw multiple threads executing the synchronized method simultaneously using different instances/object but in static 
			synchronized methods, it is at class level not at instance level. hence there is no way multiple threads can simultaneously execute a synchronized static methods.
		 * 
		 */
		J1.method();
		J1.method();
	}
}

class J1 {
	
	public static synchronized void method() {
		System.out.println(Thread.currentThread().getName() + " " + 0);
		
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " woke up from sleep");
		}catch(Exception e) {
			System.out.println("Exception occured");
		}
		
		System.out.println(Thread.currentThread().getName() + " " + 1);
	}
}
