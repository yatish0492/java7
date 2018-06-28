package com.yatish.Final.Finally.Finalize;

public class J1_What_is_final {
	
}

class FinalOnPrimitiveProperties {
	final int a; // if we are making a property as final, then that property has to be initialized there itself.
	final int b=10;
	/*
	 * By declaring the variable/property, the variable/property will become constant.
	 * 
	 * If we try to change the final variable like 'b=20' then the compiler will give error.
	 */
}


class FinalOnObjectProperties {
	final ABC obj; // if we are making a property as final, then that property has to be initialized there itself.
	final ABC obj1 = new ABC();
	/*
	 * By declaring the variable/property, the variable/property will become constant.
	 * 
	 * If we try to change the final variable like,
	 * 		ABC obj2 = new ABC();
	 * 		obj1 = obj2; 	--> This will give error.
	 */
}
class ABC {}


final class FinalOnClass {}
//This is giving error because once class is declared as final, it cannot be extended/inherited.
class DEF extends FinalOnClass {}


class FinalOnMethod {
	final void method1() {}
}
class HIJ extends FinalOnMethod {
	//This is giving error because, once method is declared as final, those methods cannot be overridden.
	@Override
	void method1() {}
}

