package com.yatish.Threads;

public class J6_Problems_With_Threads {

	/*
	 * Are there any problems in threads?
	 * Yes!!! it do have few problems to take care of.
	 * 	1) Safety failure: The program creates incorrect data.
	 * 		consider 2 or more threads are accessing a shared data. A visibility problem occurs if thread A reads shared data which is later changed by thread B and thread A is unaware of this change.
	 * 
	 * 	eg:	say a bank account(0rs balance) one thread is trying to display the balance amount and other thread is trying deduct EMI and other thread is adding
	 * 		the amount deposited by customer. consider the EMI deduction thread has altered the balance amount to minus value and then display of balance amount thread reads that and shows to the user
	 * 		that he has minus balance. and then the amount deposit thread updates the bank balance with positive value. In this case balance amount display threads doesn't know that the data is being
	 * 		changed. it is showing wrong/inconsistant information.
	 * 
	 * 	2) Liveness failure: The program does not react anymore due to problems in the concurrent access of data, e.g. deadlocks.
	 * 
	 * 
	 * What is Thread-safe?
	 * If multi-threading has been implemented in such a way that the above mentioned problems are handled.
	 * 
	 * 
	 * We got to know what is 'Thread-safe' but how do we achieve it?
	 * Java provides concurrency utilities to achieve it. 'java.util.concurrent' package.
	 */
}
