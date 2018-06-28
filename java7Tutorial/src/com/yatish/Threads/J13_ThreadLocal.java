package com.yatish.Threads;

/*
 * ThreadLocal means that variable value is specific to that thread. This was introduced in JDK 1.2. it is enhanced further in jdk 1.4
 * The ThreadLocal variables are of type 'ThreadLocal' with type of the variable. checkout the example as follows,
 * eg1 : ThreadLocal<Integer> abc = new ThreadLocal<Integer>();
 * eg2 : ThreadLocal<Student> s = new ThreadLocal<Student>(); 	--> we can use custom class objects as well like 'Student' etc.
 * 
 * Can we assign a initial value for the 'ThreadLocal' variables?
 * yes. ThreadLocal has one method 'initialValue()' we have to override this method to initialize the value for the variable when it is instantiated. The variable will be initialized with the value
 * returned by this method. In this code we have used anonymous class to override the 'initialValue()' method.
 *  
 * This concept will be clear with the demonstration done in this code.
 *  Like how the values of variables will be object specific in case of non-static fields/properties i.e. even though we have a non-static field/property in the class, for each object,
 *  the values will be unique to that object like if we create 2 object say obj1 and obj2, the 'x' field value in obj1 will be specific to obj1 object likewise for obj2 also. In the same way
 *  the ThreadLocale variables/fields/properties are specific to each thread.
 *  In this code,
 *  We have 2 ThreadLocale variables, 'abc' and 'def'. we have created 2 threads 't1' and 't2'. Both the threads are just printing the ThreadLocale variables 'abc' and 'def' as written in 'run()'
 *  method. The threadLocale variables are assigned with a random initial value. the output will be as follows,
		Thread 1 abc value --> 0.28986718205909723
		Thread 2 abc value --> 0.577719831655377
		Thread 1 obj def value --> 0.3265560344337167
		Thread 2 obj def value --> 0.5263047136876752
		Thread 1 obj1 def value --> 0.43101407735203234
		Thread 2 obj1 def value --> 0.06635218626162465
		Reprint --> Thread 1 abc value --> 0.28986718205909723
		Reprint --> Thread 2 abc value --> 0.577719831655377
		Reprint --> Thread 1 obj def value --> 0.3265560344337167
		Reprint --> Thread 2 obj def value --> 0.5263047136876752
		Reprint --> Thread 1 obj1 def value --> 0.43101407735203234
		Reprint --> Thread 2 obj1 def value --> 0.06635218626162465
	The 'abc' and 'def' values is different for 't1' and 't2'. Hence, these ThreadLocale variables scope are specific to each thread. 
	In case of static ThreadLocale variable 'abc' the value '0.28986718205909723' remains same even when 't1' accesses it form any class or any package. When we reprinted the values as you can see
	they are same for that thread.
	In case of non-static ThreadLocale variable 'def'. It is not just based on thread, it is based on the thread and object combination. as we can see for same thread 't1' when we accessed 'def' from
	'obj' the value is '0.3265560344337167' and from 'obj1' the value is '0.43101407735203234'. But the values will remain same when accessed from any class or any package. When we reprinted the values as you can see
	they are same for that thread and object combination.		
 * 
 * what is the use case we may need to use this?
 * In banking sector, they provide transaction ID to track right. For that transaction ID we can use ThreadLocale variables. whenever we initiate a transaction, a thread will be created
 *  for that request in server and that thread will executes the transaction related tasks/methods. so we need to assign a transaction ID to this thread. Since ThreadLocal variables are thread
 *  specific, we can make transaction id as ThreadLocal variable.
 */
public class J13_ThreadLocal {

	public static void main(String[] args) {
		
		G1 o1 = new G1();
		G1 o2 = new G1();
		
		Thread t1 = new Thread(o1);
		Thread t2 = new Thread(o2);
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t1.start();
		t2.start();	

	}

}

class G {
	
	static ThreadLocal<Double> abc = new ThreadLocal<Double>() {
		@Override
		protected Double initialValue() {
			return Math.random();
		}
	
	};
	
	ThreadLocal<Double> def = new ThreadLocal<Double>() {
		@Override
		protected Double initialValue() {
			return Math.random();
		}
	
	};
	
}

class G1 implements Runnable {
	
	public void run() {
	  System.out.println(Thread.currentThread().getName() + " abc value --> "+ G.abc.get());//ThreadLocal variables have few methods supported.here 'get()' method returns the value of 
	  																						//the ThreadLocal variable(abc)
	  G obj = new G();
      System.out.println(Thread.currentThread().getName() + " obj def value --> "+ obj.def.get());	
      
      G obj1 = new G();
      System.out.println(Thread.currentThread().getName() + " obj1 def value --> "+ obj1.def.get());
      
      
      System.out.println("Reprint --> " + Thread.currentThread().getName() + " abc value --> "+ G.abc.get());
      System.out.println("Reprint --> " + Thread.currentThread().getName() + " obj def value --> "+ obj.def.get());	
      System.out.println("Reprint --> " + Thread.currentThread().getName() + " obj1 def value --> "+ obj1.def.get());
			
	}
}
