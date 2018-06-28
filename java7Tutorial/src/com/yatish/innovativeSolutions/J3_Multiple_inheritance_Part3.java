package com.yatish.innovativeSolutions;

public class J3_Multiple_inheritance_Part3 {

	public static void main(String[] args) {		
		F obj = new F();
		System.out.println(obj.getLabel());
	}

}

interface G {
int a=10;
public String getLabel();
}

interface H {
int a=20;
public String getLabel();
}

class I implements G,H{


public String getLabel() {
	return a; // Even though we can achieve multiple inheritance using Interface. if we are using same property in both of them and trying to access it in implementiong class it will throw
			 // ambiguos error as shown here.
}

}
