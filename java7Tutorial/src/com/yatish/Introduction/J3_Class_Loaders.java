package com.yatish.Introduction;

public class J3_Class_Loaders {

	/*
	 * What is a class Loader?
	 * Class loader is present in the JVM, it will load the class files into JVM for executing
	 * 
	 * What is the name of the class loader in JVM?
	 * There are many class loaders in JVM,
	 * 	1)  BootStrap class Loader   ---> This will load all the class files in 'jre/lib/*.jar'
	 * 				^
	 * 				|
	 *	2)  Extension Class Loader  --> This will load all the class files in 'ext/*.jar'
	 *				^
	 *				|
	 *	3) System Class Loader --> This will load the class files present in classpath we specify.
	 *
	 *
	 * NOTE: We can create our own custom class loader by extending 'System Class Loader' but we usually don't do that in our work. The people who develop servers like tomcat or jboss etc will use
	 * this.
	 */

}
