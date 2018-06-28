package com.yatish.Threads;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * !!!!!!!!!!!!!! program not working as expected so need to get it working and then write description.
 */
public class J10_ReadWriteLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class F implements Runnable {
	public void run() {
		F1 obj = new F1();
		
	
	}
}

class F1 {
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private int value;

	public void increment() {
		lock.writeLock().lock();
		try {
			value++;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public int current() {
		lock.readLock().lock();
		try {
			return value;
		} finally {
			lock.readLock().unlock();
		}
	}
}
