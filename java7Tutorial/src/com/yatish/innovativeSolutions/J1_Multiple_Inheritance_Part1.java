package com.yatish.innovativeSolutions;

import com.yatish.Inheritance.J1_Static_Properties_Methods_Inheritance;

public class J1_Multiple_Inheritance_Part1 {

	public static void main(String[] args) {		
		C obj = new C();
		System.out.println(obj.getLabelOfBothClasses());
	
	}

}

class A {
	
	static public String getLabel() {
		return "classA";
	}
}

class B {
	
	static public String getLabel() {
		return "classB";
	}
}

class C {
	/*
	 * As we know that java doesn't support multiple inheritance. like 'class C extends A,B'. is there any other ways to achieve this multiple inheritance?
	 * Yes, there are some hacks, We can achieve multiple inheritance using Has-a relationship instead of Is-a relationship.
	 * Ash shown in this class, we have 'A' and 'B' class as data members here. hence we have access to all its properties in this class. which is achieving the multiple inheritance.
	 * 
	 * We have one more way as well, checkout the 'J2_Multiple_Inheritance_Part2.java'
	 */
	A objA;
	B objB;
	
	public String getLabelOfBothClasses() {
		return objA.getLabel() + "   " + objB.getLabel();
	}
}