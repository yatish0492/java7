package com.yatish.String;

public class J1_What_is_String {

	public static void main(String[] args) {
		
		/*
		 * How is string stored internally?
		 * It is stored as charecter array 'char[]'
		 * 
		 * 
		 * 
		 * I have heard string is immutable and final, can you please explain?
		 * one we create a string we cannot change it. even if we do some modification to the string, there will be a new string created, the existing string will not be changed.
		 * eg: s = "yatish";
		 * 	   s = "Gagan";		--> In this case, "yatish" will not be changed to "Gagan" in memeory. a new string "Gagan" will be created and that reference will be assigned to 's'. "yatish" will be
		 * 							cleaned up by garbage collector if there are no other reference.
		 * similarly, s.toUpperCase()/s.toLowerCase()/s.substr() etc won't change the 's' variable. It will create new result string and return it.
		 * 
		 * 
		 * 
		 * What is String pool?
		 * The strings are stored in a pool called 'string pool'. It will be present in the heap memory.
		 * 
		 * 
		 * 
		 * 
		 * What is string literal vs string object?
		 * String literal --> String s = "abc";
		 * String object  --> String s = new String("abc");
		 * 
		 * String literal --> String s = "abc";
		 * 					  String m = "abc";	--> In this case, java will not create new string "abc" in string pool. First java will check whether if "abc" is already present in the string pool 
		 * 											or not. if it is present then it will point to the existing string instead of creating new one. In this case, it will reference to the existing 
		 * 											"abc" string in the string pool.
		 * String object  --> String s = new String("abc");  --> This will create a new string "abc" in string pool, irrespective of whether already "abc"  is present in the string pool or not.
		 * 
		 * 
		 * How does spring check whether if the string is already present in the string pool or not?
		 * While storing the strings in string pool, the hash code of the string is calculated based on the charecters.
		 * 
		 */
		String s = "yatishti";
		
		
		/*
		 * '.matches' method
		 * ------------------
		 * This method is used to check whether the string matches with the regular expression or not. 
		 */
		s.matches(".*tishti");		// return 'true' as regular expression says, 0 or more charecters but should end with 'tishti'.
		
		
		
		s.charAt(2);   // return 't'
		s.indexOf('t');  // return '2'
		s.lastIndexOf('t');  // return '6'
		s.indexOf("ti");  // return '2'
		s.lastIndexOf("ti");   //return '6'
		s.contains("tish"); //return 'true'
		
		/*
		 * There was memory leak problem in string till java 1.6, This was fixed in java 1.7.
		 * Actually, In 'substring()' function, the new substring created will not just contain "atish", it creates a new string "yatishti" using 'new' keyword and put the offset as provided
		 * in beginning and end index. Hence even though we don't want the big string it was creating "yatishti" instead of "atish".
		 */
		String s1 = s.substring(1,6);  // return "atish", beginning index is inclusive where as ending index is exclusive
		
		
		
		

	}

}