package com.yatish.Threads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class J12_Automic_Variables {

	/*
	 * Atomic Variables are used to develop a thread safe program. To get more clarity on when we need to use this please refer to description in 'J11_volatile.java'
	 * 
	 * Java provides these atomic variables under 'java.util.atomic' package. For shared resources/variables across threads just to make it thread safe it is better to use atomic variables instead
	 * of normal variables. if that variable is being changed by multiple threads.
	 */
	public static void main(String[] args) {
		AtomicInteger a = new AtomicInteger();
		
		AtomicLong b = new AtomicLong();
		
		AtomicBoolean c = new AtomicBoolean();
		
		AtomicReference d = new AtomicReference();
		
		
		
	}


}
