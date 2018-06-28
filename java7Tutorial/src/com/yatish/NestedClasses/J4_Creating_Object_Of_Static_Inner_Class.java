package com.yatish.NestedClasses;

public class J4_Creating_Object_Of_Static_Inner_Class {

	public static void main(String[] args) {
		
		/*
		 * We are accessing static method in following code. no need to instantiate the outer class 'A' to access it because class 'B' is a static member of outer class 'B' 
		 */
		String str = A.B.getStaticLabel();
		
		System.out.println(str);

	}

}


class A {
	
	String nonStaticLabel="non Static Label";
	static String StaticLabel = "Static Label";
	
	static class B {
		
		static public String getStaticLabel() {
			/*
			 * We are accessing and returning the static field/property 'StaticLabel' of outer class 'A'. But if i try to access a non-static field/property 'nonStaticLabel' of outer class,
			 * java 8 compiler will throw an error.
			 * 
			 * NOTE: in a static inner class, we can only access static fields/properties or methods of outer class. we cannot access non-static fields or methods of outer class.
			 */
			return StaticLabel;
		}
		
		/*
		 * I have written a non-static method in a 'static' class. java compiler is not throwing any error!!!! does that mean it is correct, we can access this method?
		 * No. we cannot access this method at all. but still java compiler is not throwing an error, which is wrong. java compiler should be enhanced is what i feel.
		 * 
		 * Consider if i try to access this method using 'A.B.m();'. will that work?
		 * No. compiler will throw an error. saying it cannot reference to 'm()' method.
		 * 
		 * 
		 * 
		 */
		public void m() {}
	}
}
