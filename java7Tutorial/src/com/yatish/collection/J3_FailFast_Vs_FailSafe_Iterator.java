package com.yatish.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class J3_FailFast_Vs_FailSafe_Iterator {

	public static void main(String[] args) {
		
		/*
		 * Fail safe --> CopyOnWriteArrayList and ConcurrentHashMap 
		 */
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			int a = itr.next();
			System.out.println(a);
			itr.remove(); // if we do remove after next() then it will work. 
			
		}
		
//		Map<Integer,String> concurrentMap = new ConcurrentHashMap<Integer,String>();
//		concurrentMap.put(1, "yatish");
//		concurrentMap.put(2, "Gagan");
//		Iterator<Integer> itr1 = concurrentMap.keySet().iterator();
//		while(itr1.hasNext()) {
//			itr1.remove();
//			itr1.next();	
//		}
	}

}
