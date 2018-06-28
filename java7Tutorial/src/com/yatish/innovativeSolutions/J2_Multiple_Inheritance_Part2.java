package com.yatish.innovativeSolutions;

public class J2_Multiple_Inheritance_Part2 {

	public static void main(String[] args) {		
		F obj = new F();
		System.out.println(obj.getLabel());
	}

}

interface D{
	int a=10;
	public String getLabel();
}

interface E {
	int a=20;
	public String getLabel();
}

class F implements D,E{
	/*
	 * As we know that java doesn't support multiple inheritance. like 'class C extends A,B'. is there any other ways to achieve this multiple inheritance?
	 * Yes, there are some hacks, We can achieve multiple inheritance using Has-a relationship instead of Is-a relationship.
	 * Ash shown in this class, we have 'A' and 'B' class as data members here. hence we have access to all its properties in this class. which is achieving the multiple inheritance.
	 * 
	 * We have one more way as well, checkout the 'J2_Multiple_Inheritance_Part2.java'
	 */
	
	public String getLabel() {
		return "class F";
	}

}