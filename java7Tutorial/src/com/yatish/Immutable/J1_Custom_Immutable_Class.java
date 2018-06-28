package com.yatish.Immutable;

import java.util.HashMap;
import java.util.Iterator;

public class J1_Custom_Immutable_Class {

	/*
	 * 	Declare the class as final so it can’t be extended.
		Make all fields private so that direct access is not allowed.
		Don’t provide setter methods for variables
		Make all mutable fields final so that it’s value can be assigned only once.
		Initialize all the fields via a constructor performing deep copy.
		Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
	*/
	
	
}


final class ImmutableClass {

	private final int id;
	
	private final String name;
	
	private final HashMap<String,String> testMap;
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	/**
	 * Accessor function for mutable objects
	 */
	public HashMap<String, String> getTestMap() {
		//return testMap;
		return (HashMap<String, String>) testMap.clone();
	}

	/**
	 * Constructor performing Deep Copy
	 * @param i
	 * @param n
	 * @param hm
	 */
	
	public FinalClassExample(int i, String n, HashMap<String,String> hm){
		System.out.println("Performing Deep Copy for Object initialization");
		this.id=i;
		this.name=n;
		HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, hm.get(key));
		}
		this.testMap=tempMap;
	}
}
