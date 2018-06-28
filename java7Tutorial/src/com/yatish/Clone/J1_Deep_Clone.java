package com.yatish.Clone;

public class J1_Deep_Clone {

	public static void main(String[] args) {
		
		Clone obj1 = new Clone();
		obj1.a = 10;
		Clone obj2 = null;
		try {
			obj2 = (Clone)obj1.clone();
		}catch(CloneNotSupportedException e ) {}
		
		obj2.a = 20;
		System.out.println(obj1.a);
		
		

	}

}

class Clone implements Cloneable{
	int a;
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
