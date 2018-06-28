package com.yatish.garbage.collection;

public class J1_What_Is_GarbageCollection {

	/*
	 * What is Garbage Collection?
	 * In Java, The object which we are not referencing will be deleted automatically. This is called as garbage collection.
	 * 
	 * Can you show how we may loose the object reference?
	 * 1) Student obj  = new Student();
	 * 	  obj = null; 		--> the object created and assigned to 'obj' is eligible for cleanup by garbage collection.
	 * 2) Student obj = new Student();
	 * 	  Student obj1 = new Student();
	 * 	  obj = obj1; 		--> the object created and assigned to 'obj' is eligible for cleanup by garbage collection.
	 * 
	 * 
	 * NOTE: Garbage Collector is a daemon thread, which will be running in background.
	 */
}
