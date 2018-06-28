package com.yatish.Interface;

public class J2_Access_Interface_Properties {
	
	public static void main(String args[]) {
		/*s
		 * No need to implement an interface just to use that class to access the interface property. why?
		 * by default java compiler will add 'public final static' to the interface properties. since it is a static method, we can access them by just using interface name.
		 */
		System.out.println(B.label);
	}
}

interface B {
	String label="interfaceA";
}
