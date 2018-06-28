package com.yatish.Threads;

public class J16_Why_Semaphores {

	/*
	 * Problems with wait,notify and notifyAll?
	 * 1) Missed Signals
	 * 2) Spurious Wakeups
	 * 
	 * Missed Signals
	 * --------------
	 * problem
	 * *******
	 * We know that a thread will goto wait state using 'wait()' and then the thread will be waken up by 'notify()' or 'notifyAll()'. we call a 'wait()' method on a thread assuming that later the
	 * notify() or notifyAll() call will wake it up. Consider there is some sync issue and the 'notify()' or 'notifyAll()' is being recieved before 'wait()' hence the signal is lost, later on when
	 * thread calls 'wait()' and stays in the wait state forever as the 'notify()' or 'notifyAll()' signal is already lost.
	 * Solution
	 * ********
		public class MyWaitNotify2{
		
		  MonitorObject myMonitorObject = new MonitorObject();
		  boolean wasSignalled = false;							--> you need to use a boolean variable as flag. to specify whether the notify signal is already sent or not.
		  															if it is true, that means the notify signal is already sent.
		  															if it is false, that the notify signal is not sent yet.
		
		  public void doWait(){
		    synchronized(myMonitorObject){
		      if(!wasSignalled){									--> Before, calling 'wait()', we are checking the flag which specifies whether the notified signal is already sent or not. If it false
		        try{													then only, 'wait()' will be called. Hence Missed Signals problem solved.
		          myMonitorObject.wait();
		         } catch(InterruptedException e){...}
		      }
		      //clear signal and continue running.
		      wasSignalled = false;
		    }
		  }
		
		  public void doNotify(){
		    synchronized(myMonitorObject){
		      wasSignalled = true;				--> Setting the flag to 'true' just before sending the notify signal.		
		      myMonitorObject.notify();	
		    }
		  }
		}
	 * 
	 * 
	 * Spurious Wakeups
	 * ----------------
	 * problem
	 * *******
	 * sometimes the threads in waiting state wakes up without any 'notify()' or 'notifyAll()' signal. Hence it is dangerous if a thread is waken up without developers knowledge/without any notify 
	 * signals.
	 * Solution
	 * ********
	 * The same solution provided above for 'Missed Signals' will work for this as well but with one change instead of checking the flag in 'if' condition, we have to check the flag in a loop.
	 * 
		  public void doWait(){
		    synchronized(myMonitorObject){
		      while(!wasSignalled){			--> since we are checking the flag in a loop, consider if the thread wakes up spuriously. In that case also the the woken up thread will loop over and see
		        try{								that the flag is still false and again comes inside the loop and sends it to waiting state. Hence even if spurious Wakeups happen also it is put back
		          myMonitorObject.wait();		to wait state. Hence problem solved.
		         } catch(InterruptedException e){...}
		      }
		      //clear signal and continue running.
		      wasSignalled = false;
		    }
		  }
	 * 
	 * 
	 * 
	 */

}
