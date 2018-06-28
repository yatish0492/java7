package com.yatish.String;

public class J3_Why_Strings_Are_Immutable {

	
	/*
	 * String pool (String intern pool) is a special storage area in Java heap. When a string is created and if the string already exists in the pool, the reference of the existing string will be returned, instead of creating a new object and returning its reference.

		The following code will create only one string object in the heap.
		
		String string1 = "abcd";
		String string2 = "abcd";
		
		If string is not immutable, changing the string with one reference will lead to the wrong value for the other references.

2. Allow String to Cache its Hashcode

The hashcode of string is frequently used in Java. For example, in a HashMap. Being immutable guarantees that hashcode will always the same, so that it can be cashed without worrying the changes.That means, there is no need to calculate hashcode every time it is used. This is more efficient.

3. Security

String is widely used as parameter for many java classes, e.g. network connection, opening files, etc. Were String not immutable, a connection or file would be changed and lead to serious security threat. The method thought it was connecting to one machine, but was not. Mutable strings could cause security problem in Reflection too, as the parameters are strings.
	 */
}
