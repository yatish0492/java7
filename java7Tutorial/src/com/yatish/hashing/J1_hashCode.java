package com.yatish.hashing;

public class J1_hashCode {

	public static void main(String[] args) {
		
		A obj = new A("yat");
		A obj1 = new A("yat");
		
		/*
		 * what is the default implementation of '.hashCode()' in 'Object' class, if we don't override it?
		 * The default implementation will calculate the hash code using the memory address of the object.
		 */
		System.out.println(obj.hashCode());
		System.out.println(obj1.hashCode());
		
		
		/*
		 * what is the default implementation of the '.equals' in 'Object' class, if we don't override it?
		 * It will refer to the memory address of the objects to see whether object are equal or not. basically it will do 'obj' == 'obj1'.
		 * 
		 * we have both objects 'obj' and 'obj1' with same value for the property 'str' but still 'obj.equals(obj1)' is giving false why?
		 * since we have not overridden 'equals' method. it is doing 'obj == obj1' in which it checks whether if memory address of 'obj' and 'obj1' are same or not. as the memory address of both
		 * objects are different it gives false.
		 * 
		 * 
		 */
		System.out.println(obj.equals(obj));
		System.out.println(obj.equals(obj1));

	}

}


class A {
	
	String str;
	
	A(String str) {
		this.str = str;
	}
}
