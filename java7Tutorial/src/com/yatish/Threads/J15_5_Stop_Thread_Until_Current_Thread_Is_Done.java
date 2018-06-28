package com.yatish.Threads;

public class J15_5_Stop_Thread_Until_Current_Thread_Is_Done {

	public static void main(String[] args) {
			
			final StopUntilDone obj = new StopUntilDone();
			
			Runnable thread1 = new Runnable() {
				public void run() {
					obj.printEven();
				}
			};
			
			Runnable thread2 = new Runnable() {
				public void run() {
					obj.printOdd();
				}
			};
			
			Thread t1 = new Thread(thread1);
			Thread t2 = new Thread(thread2);
			
			t2.start();
			t1.start();
			

		}

	}


	class StopUntilDone {
		
		public void printEven() {
			synchronized(this) {
				for(int i = 0; i < 100; i=i+2) {
					System.out.println(i);
				}
				try {
					notify();
				}catch(Exception e) {}
			}
		}
		
		public void printOdd() {
			synchronized(this) {
				try {		
					wait();
				}catch(Exception e) {}
				
				for(int i = 1; i < 100; i=i+2) {
					System.out.println(i);
					
				}
				
			}
		}
	}