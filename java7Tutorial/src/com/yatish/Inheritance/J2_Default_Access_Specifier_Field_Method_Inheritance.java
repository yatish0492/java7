package com.yatish.Inheritance;

public class J2_Default_Access_Specifier_Field_Method_Inheritance {
	
	String label="class J2_Default_Access_Specifier_Field_Method_Inheritance";
	
	public static void main(String[] args) {
		
		/*
		 * Here property with default access specifier of 'C' class has been inherited to the child class 'D'. due to which only we are able to print the label using object of 'D' class.
		 * 
		 * Consider, I extend this class 'J2_Default_Access_Specifier_Field_Method_Inheritance' in some other package class. then the property 'label' with default access specifier will 
		 * not be inherited to that class 
		 */
		D obj = new D();
		System.out.println(obj.label);
	}
}


class C {
	String label = "class A";
}

class D extends C{}
