package com.yatish.NestedClasses;

public class J3_Creating_Object_Of_Inner_Class {

	public static void main(String[] args) {
		
		/*
		 * To create an object of an inner class first we have to create an object of the outer class. using this object we can create an object of inner class.
		 */
		OuterClass obj = new OuterClass();
		System.out.println("The outerclass Label accessing from Outer Class - " + obj.outerlabel);
	
		/*
		 * We cannot access an inner class properties or methods by using the outer class object directly.
		 */
		String s = obj.innerLabel;
		
		/*
		 * we are creating an object(obj1) of inner class in the below code. we are using outer class object 'obj'. as 'obj.new InnerClass();
		 */
		OuterClass.InnerClass obj1 = obj.new InnerClass();
		System.out.println("The outerclass Label accessing from Inner Class - " + obj1.getOuterClassLabelFromInnerClass());
		System.out.println("The inner Label accessing from Inner Class - " + obj1.innerlabel);
		System.out.println("The outerclass Label accessing from Outer Class - " + obj.outerlabel);
	}
}

class OuterClass {
	/*
	 * The inner class can access the fields or methods of outer class but the outer class cannot access the inner class fields or methods.
	 * 
	 * so there is no way at all to access the inner class fields or methods from outer class?
	 * Yes, there is a hack to do that!!!! by creating an object of inner class in parent class method we can access them.
	 * eg: InnerClass obj = new InnerClass();
	 * 		obj.innerLabel;
	 * 
	 */
	String outerlabel="OuterClass";
	
	class InnerClass {
		
		String innerlabel = "InnerClass";
		
		public String getOuterClassLabelFromInnerClass() {
			/*
			 * We are accessing the variable(outerlabel) of the outer class.
			 * 
			 * A inner class will be having the access to all the methods or fields/properties of the outer class. even though they are private.
			 */
			outerlabel = "abc";
			return outerlabel;
		}
	}
}
