package com.yatish.Threads;

public class J7_3_Synchronized_Block {

	static H1 obj = new H1();
	public static void main(String[] args) {
		H t1 = new H();
		H t2 = new H();
		
	
		Thread o1 = new Thread(t1);
		Thread o2 = new Thread(t2);
		o1.setName("Thread 1");
		o2.setName("Thread 2");
		
		o1.start();
		o2.start();

	}

}

class H implements Runnable {
	public void run() {
		
		J7_3_Synchronized_Block.obj.method();
	}
}

class H1 {

	/*
	 * Consider you don't want complete method to be synchronized, you want to synchronize only part of the method. Then you can use synchronized block.
	 * 
	 * Why do i want to synchronize only part of method in what scenario would i do that?
	 * Consider you have the critical data manipulation code in just 3 lines of code in a method which has 100+ lines. letting the threads to execute 100+ lines sequentially will take more time than
	 * letting the threads execute only 3 lines sequentially.
	 * 
	 * NOTE: the synchronized block may be non-static method block or a static method block. If it is a non-static synchronized block, then multiple threads can excecute the block
	 * 		simutaneously using different instances. But if it is static synchronized block, then there is no way multiple threads can execute the static synchronized block simultaneously.
	 * 
	 * What does the parameter we specify in 'synchronized()' do? why should we specify it?
	 * That is one more way of making a synchronized block as static or non-static.
	 * If we specify 'this', then it will act as non-static synchronized block.
	 * if we specify 'this.getClass', then it will act as static synchronized block.
	 * 
	 */
	public void method() {
		synchronized(this) {
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
}
