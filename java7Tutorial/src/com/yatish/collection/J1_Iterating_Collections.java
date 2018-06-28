package com.yatish.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class J1_Iterating_Collections {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("yatish","ashok","ramya");
		Collection<String> collection = new ArrayList(names);
		/*
		 * There are 3 ways to iterate over a collection. please find them in the code below.
		 */
		
		
		// using 'for' loop. NOTE: this way can be used only on LIST and MAP, not on SET because SET doesn't support '.get()' 
		for(int i=0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		// using 'for each' loop.This way can be used in all the collections.
		for(String eachElement:collection) {
			System.out.println(eachElement);
		}
		
		//using Iterator(). This way can be used in all the collections.
		Iterator<String> itr = collection.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
