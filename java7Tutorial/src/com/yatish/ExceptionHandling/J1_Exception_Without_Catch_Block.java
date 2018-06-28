package com.yatish.ExceptionHandling;

import java.io.File;
import java.io.FileInputStream;

public class J1_Exception_Without_Catch_Block {

	public static void main(String[] args) {
		WithoutCatch obj = new WithoutCatch();
		obj.WithoutCatchOnFinally();
	}

}

class WithoutCatch {
	
	public void WithoutCatchOnFinally() {
		try {
			System.out.println("Before Exception");
			int a = 9/0;
			System.out.println("After Exception");
		} finally {
			System.out.println("In Finally");
		}
	}
}
