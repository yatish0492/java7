package com.yatish.Threads;

public class J1_What_is_Thread {

	/*
	 * Consider that you need to send the purified water from kashmir to kanyakumari. consider,
	 *  water flow as -->  control flow
	 *  the pipelines as --> threads
	 *  The purifier as --> processor
	 *  Pipeline breakage and waiting for it to be fixed --> Thread waiting for resource to be free like waiting for disk/resource to be free etc.
	 *  
	 *  problem without multi-threading
	 *  -------------------------------
	 *  In old days, we had a single pipeline(single Thread) from kashmir to kanyakumari. There was a single water purifier(processor) at Mumbai. it used to purify water sequentially and send to
	 *  kanyakumari. Consider if there is pipeline breakage(Thread waiting for disk to be free to read/write) and water supply is stopped at the breakage point till it gets repaired. At this point of
	 *  time, water purifier(processor) is idle, it is waste of resource we could have utilized it better by keeping it busy all time.
	 *  
	 *  Solution: Multi-threading
	 *  -------------------------
	 *  So engineers came up with one solution of keeping multiple pipelines(multiple-threads) instead of one. so that the water will be sent in multiple pipelines(multiple-threads) from kashmir, 
	 *  so that whenever a pipeline breakage(Thread waiting for disk to be free to read/write) happens, the water can flow(control flow) from other pipes can be purified in the water purifier(processor).
	 *  Hence water purifier(processor) will be kept busy all the time instead of keeping it idle. hence best usage of resource.
	 *  
	 *  Problem with multi-tasking
	 *  --------------------------
	 *  If the water comes in multiple pipelines, the purifier(processor) can handle only one pipeline water, it cannot handle so much water from all those pipelines. Hence it is problem to handle so
	 *  much of load. i.e. cannot process all the threads simultaneously with this processor.
	 *  
	 *  Solution: Thread Scheduling
	 *  ---------------------------
	 *  So based on some algorithms(Scheduling algorithms) engineers decided to balance the purification(processing) of water. one way is for 5 minutes, purifier(process) will purify(process) 
	 *  one pipeline(one thread) water and for next 5 minutes purify water from other pipeline in round robin manner. i.e. each thread is executed based on some scheduling algorithm.
	 *  
	 *  
	 *  Still more performance improvement
	 *  ----------------------------------
	 *  Engineers thought of improving the performance much more and installed more number of purifiers(processors) so that if 5 pipelines(threads) are there and 5 water purifiers(processors) are 
	 *  there then each purifier will handle each pipeline water. i.e. if there are multiple processors then each thread is executed on each processor parallelly.
	 *  
	 *  
	 *  How to find the maximum number of threads that can be processed in parallel?
	 *  = (no. of processors) * (no. of cores).
	 *  
	 *  
	 *  
	 *  How is memory managed for Threads?
	 *  In Threads, Following memory model will be done,
	 *  1) Stack Memory
	 *  2) Heap Memory
	 *  3) class Memory
	 *  Stack Memory
	 *  ------------
	 *  For each Thread, an individual stack memory will be created, this stack memory will contain following information. 
	 *  		a) Program counter --> The pointer which points to the statement at which the execution point is at currently.
	 *  		b) callbacks/stackTrace --> The pointers to calling functions to return the control back after function execution within thread.
	 *  		c) local variables
	 *  		d) Return value from functions
	 *  Heap Memory
	 *  -----------
	 *  It is not specific to each Thread, it is shared across threads. It is the place where objects are stored.
	 *  Class memory
	 *  ------------
	 *  It is also not specific to teach Thread, it is shared across threads. It is the place where classes and class level things are stored like the static fields and static methods  are stored.
	 * 
	 *  
	 *  NOTE: even if we don't create threads, the JVM creates a thread to execute the main function. and the memory model of that thread is also same as above. Hence this memory model is generic to
	 *  			java.
	 * 
	 * 
	 * 
	 */
}
