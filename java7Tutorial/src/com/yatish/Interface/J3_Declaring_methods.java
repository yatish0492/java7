package com.yatish.Interface;

public class J3_Declaring_methods {}

interface C {
	
	/*
	 * If you are specifying a abstract method in interface with parameters, just specifying the data type is not enough. java compiler will throw an error as it is throwing for the method
	 * in the code. we have to specify parameter name also like as follows,
	 * 		void someMethod(String str);		// putting the parameter name, in this case'str' will solve the issue.
	 * 
	 */
	void someMethod(String);
}
