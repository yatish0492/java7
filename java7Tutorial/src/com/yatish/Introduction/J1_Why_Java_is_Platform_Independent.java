package com.yatish.Introduction;

public class J1_Why_Java_is_Platform_Independent {

	/*
	 * How is Java Platform Independent? 
	 * C++ will convert the '.cpp' file to '.out' file which contains binary 0 and 1, which is specific to the platform. i.e. '.out' file compiled on windows cannot run on Linux because, the binary
	 * 		code in '.out' file is different for different platforms.
	 * Java will convert the '.java' file to '.class' file which contains 'bytecode', which is not specific to the platform. i.e. '.class' file compiled on windows can be run on Linux or any other
	 * 		platforms. But we need to have JVM installed, which is lightweight. JVM will then convert the 'bytecode' to binary file '.obj' specific to corresponding platform.
	 * 
	 * So JVM will convert '.class' files into equivalent binary files?
	 * NO!!!
	 * JVM doesn't execute the bytecode, it will interpret the bytecode. i.e. it will goto a line and it will convert that line to binary code and then it will execute it.
	 * 
	 * NOTE: There is one famous phrase for 'Platform Independency of java', that is - "write once, run anywhere"
	 * 
	 * 
	 * How dare you say JVM is a interpreter. how do you know that it will simply interpret each and every line sequentially?
	 * Consider you write a code as follow,
	 * 		System.out.println(name);
	 * 		String name = "yatish";
	 * This will given error because, java will execute 'System.out.println(name)' and doen't have any idea that 'name' has been defined in next line because, it will not scan the complete file,
	 * it will go line by line only. If it would have scanned the complete file, it would have known that 'name' is defined later and it wouldn't have given any error on running this code.
	 * 
	 * 
	 */
}
