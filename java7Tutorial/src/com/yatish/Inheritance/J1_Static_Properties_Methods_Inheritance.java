package com.yatish.Inheritance;

public class J1_Static_Properties_Methods_Inheritance {

	String access="Permission Check";
	
	public static void main(String[] args) {
		
		/*
		 * The static properties or methods will be inherited to the child classes based on access specifier of them. so only we are able to access the static field 'label' and static method
		 * 'getLabel' using the object of child class 'B'.
		 * 
		 * NOTE: we can also access them using just the class name as well, as shown in this example 'A.label' and 'A.getLabel()'
		 */
		B obj = new B();
		System.out.println(obj.label);
		System.out.println(obj.getLabel());
		System.out.println(A.label);
		System.out.println(A.getLabel());

	}

}

class A {
	static String label="class A";
	
	static String getLabel(){
		return label;
	}
}

class B extends A {
	
}
