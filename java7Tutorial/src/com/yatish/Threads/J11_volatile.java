package com.yatish.Threads;

public class J11_volatile {

	/*
	 * Problem
	 * -------
	 * consider your system has multiple CPUs and you are running lot of threads. consider there is shared resource 'int counter=0' which is being referenced by all the threads. For better performance
	 * OS will run the threads on multiple CUPs. Do you think the threads will each and every-time refer to the shared resource 'counter' from main memory? No, it will cache the 'counter' value in
	 * CPU cache. threads keep on updating the 'counter' variable in the CPU cache and that will be synced to the 'counter' variable in main memory with some interval. consider a thread in
	 * CPU1 will updates the 'counter' value to 7 in its CPU cache, after fews seconds it will update the 'counter' value in main memory so that all the other threads will come to know about the new 
	 * value. But in that few seconds other threads will be using wrong value of 'counter' as 0 only which is not correct.
	 * 
	 * Solution
	 * --------
	 * By declaring the shared resource with volatile key, synching the shared resource values in main memory and CPU caches will be done immediately as soon as value changes in any place instead of
	 * synching with some interval like few seconds.
	 * 
	 * Does the solution solve it completely
	 * -------------------------------------
	 * consider a thread needs to read the shared resource first and based on its current vaule it needs to increment it. consider 'counter' value is 0 in main memory. thread 1 and thread 2 reads 
	 * it to cache at same time and they will update it to 1 at same point of time in its CPU cache which will be immediately synched the main memory which will be 'counter' value as 1. 
	 * In this case, actual 'counter' value should be 2 not 1.
	 * 
	 * Solution
	 * --------
	 * It is better to go with 'synchronized' to avoid these problems.
	 * Note: Synchronized will block the threads and let them execute the threads one after the other. due to this the performance will get a hit right? Yes. So there is one more alternative instead
	 * 		of using synchronized as a solution, which is 'Automic Variables'. Refer to 'J12_Automic_Variables.java'  
	 * 
	 * So, when can we use volatile then?
	 * ----------------------------------
	 * If one thread is writing to the shared resource and other threads are reading the shared resources then you can use volatile it is enough. If more than one threads are doing both read and write
	 * on the shared resource then synchronized is the best option.
	 * 
	 */
	
	volatile int counter;		// this is a volatile variable/resource.
	
	/*
	 * In below code, we have made an array as volatile, does volatile apply on all the elements of the array?
	 * No!!! in this case, the volatile will be applies only to array reference itself. that means the memory address/pointer.
	 * 
	 * Then, How can i make the array elements volatile?
	 * use a class like AtomicIntegerArray to create an array with volatile like entries. like 'AtomicInteger[] counterArray;'
	 */
	volatile int[] counterArray;
	
	
	public static void main(String[] args) {
		
		

	}

}

