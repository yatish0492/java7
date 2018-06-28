package com.yatish.AbstractClass;

public class J1_Calling_AbstractMethod_within_AbstractClass {
}

abstract class A {
	
	abstract public void method1();
	
	/*
	 * we can call an abstract method as shown in below method 'method2()'. 
	 * 
	 * here abstract method doesn't have a definition. don't you thing calling an abstract method without a definition may cause error?
	 * No!!!
	 * we cannot instantiate an abstract class. hence we have to extend this class and that class only can be initiated. in that class, we have to mandatorily define the abstract methods.
	 * in this case, we have to implement 'method1()' in the extending class. hence we can call 'method2()' from the class extending this abstract class only, in that class definition of 
	 * 'method1()' will be there. hence no problem.
	 * 
	 */
	public void method2() {
		method1();
	}
}
