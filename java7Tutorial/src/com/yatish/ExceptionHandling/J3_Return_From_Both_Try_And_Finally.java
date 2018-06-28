package com.yatish.ExceptionHandling;

public class J3_Return_From_Both_Try_And_Finally {

	public static void main(String[] args) {
		ReturnInBothTryAndFinallyBlock obj = new ReturnInBothTryAndFinallyBlock();
		System.out.println(obj.WithoutCatchOnFinally());
	}

}

class ReturnInBothTryAndFinallyBlock {
	
	public String WithoutCatchOnFinally() {
		try {
			System.out.println("Before Exception");
			return "Returned from Try block";	// even if we return in try also, finally will be executed.
		} finally {
			System.out.println("In Finally");
			return "Returned from finally block";	//Returned value from this bloack will be returned not from try block
		}
	}
}

