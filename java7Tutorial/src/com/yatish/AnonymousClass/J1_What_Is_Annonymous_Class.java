package com.yatish.AnonymousClass;

public class J1_What_Is_Annonymous_Class {

	public static void main(String[] args) {
		
		final String str = "yatish";
		
		/*
		 * Anonymous class is an inner class without a name. There are slight differences though like anonymous class cannot access private fields/properties of the outer class. You can 
		 * access private methods of outer class.
		 * 
		 * So do we write a anonymous class within a class definition?
		 * No!!!!! Anonymous class is not defined at class level. it is defined at object level. hence we write the anonymous class definition while creating the object. The anonymous class
		 * written while creating an object of class say 'A', will not be applicable to any other objects of class 'A'.
		 * syntax: A obj = new A() { <anonymous_class_definition> }
		 * eg: refer to the object creation of class 'A' in below code.
		 * 
		 */
		A obj = new A() {
			
			/*
			 * You can add a field/property in anonymous class but you can use them only within this block/anonymous class. you cannot access 'temp' field using class 'A' object.
			 * eg: 'obj.temp' will give a compile error
			 * 
			 */
			String temp = "anonymous class field/property";
			
			/*
			 * whatever has been written in this block is anonymous class. we are overriding a method of class 'A' in anonymous class.
			 * 
			 * Apart from overriding, can we add a new method say 'public void m() {.....}' in this anonymous class?
			 * No!!!!
			 * you can only override a method in anonymous class, But you cannot add a new method to it.
			 * 
			 * NOTE: we can access all the fields/properties of class 'A' except 'private' fields/properties'.
			 */
			public void printHello() {
				/*
				 * in anonymous class, we are accessing 'str' which is outside of anonymous class body. !!!! how is that possible?
				 * Yes it is possible. we can use such local variables of enclosing scope. But that variable should be of 'final'. If you try to use a 'non-final' local variables of 
				 * enclosing scope, then java. compiler will throw an error.
				 *
				 */
				label="hello" + "  " + str + " " + temp;
				System.out.println(label);
			}
		};		// be sure to give ';' at the end of the anonymous class body.
		
		
		obj.printHello();

		/*
		 * NOTE: Anonymous classes can be written for interface and abstract classes also. for information
		 * 
		 * Conclusion : The anonymous classes are used only for overriding methods/implementing for a particular object.
		 */
	}

}

class A {
	String label="";
	void printHello(){};
}
