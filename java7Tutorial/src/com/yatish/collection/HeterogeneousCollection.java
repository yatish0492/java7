package com.yatish.collection;

import java.util.ArrayList;
import java.util.List;

public class HeterogeneousCollection {

	public static void main(String[] args) {
		/*
		 * Need to find yet below code is just experiementing with List and Array
		 */
		List<Object> list = new ArrayList<Object>();
		List<Student> list1 = new ArrayList<Student>();
		Object[] array = new Object[10];
		Student[] objarray = new Student[2];
		
		String str = "hello";
		Integer integer = 100;
		Double dlb = 169.0;
		Student studentObj = new Student();
		Engineer engineerObj = new Engineer();
		
		array[0] = str;
		array[1] = integer;
		
		System.out.println(array[0]);
		System.out.println(array[1]);
		//System.out.println(array[1] + 200);
		
		list1.add(studentObj);
		list1.add(engineerObj);
		
		objarray[0] = studentObj;
		objarray[1] = engineerObj;
		
	}

}


class Student {
	
}


class Engineer extends Student {}
