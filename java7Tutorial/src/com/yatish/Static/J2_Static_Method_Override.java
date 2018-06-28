package com.yatish.Static;

public class J2_Static_Method_Override {

	public static void method1() {
		System.out.println("J2_Static_Method_Override static method");
	}
	
	public static void main(String[] args) {
		J2_Static_Method_Override obj = new B();
		obj.method1();	// Even though we are calling the static method from object of 'B', the method of 'J2_Static_Method_Override' will be called since the variable type we are using is of type
						// 'J2_Static_Method_Override' not 'B'
		
		J2_Static_Method_Override obj1 = null;
		obj1.method1();	// Even though we are assigning 'null' to variable, the static method will be called without null pointer exception. because, just irrespective of object assigned to the 
						// variable, it will call static method based on variable type.
	}

}

class B extends J2_Static_Method_Override {
	
	public static void method1() {
		System.out.println("B class static method"); 
	}
}
