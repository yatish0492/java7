package com.yatish.AnonymousClass;

public class J2_Annonymous_Class_With_Interfaces {

	public static void main(String[] args) {
		
		/*
		 * We are directly creating an object of interface type!!!
		 * Yes. the implementation of the interface is written as anonymous class.
		 * 
		 * Why do we call it as anonymous class?
		 * Using anonymous class, we can directly create an object of the interface without writing a seperate class which implements this interface. We can write the implementation in the '{}' while
		 * creating the object. since we are writing the class without a class name, we gave the name as anonymous class.
		 * 
		 * The anonymous class definition applied to only 'obj' object, consider we create one more object say 'obj1' for that this anonymous class definition doesn't apply.
		 */
		B obj = new B() {
			/*
			 * We have to implement all the abstract methods present in the interface in anonymous class. otherwise there will be a compilation error.
			 */
			public void printInterfaceImplemented() {
				System.out.println("Interface have been implemented without writing any class");
			}
		};
		
		obj.printInterfaceImplemented();

	}

}

interface B {
	void printInterfaceImplemented();
}