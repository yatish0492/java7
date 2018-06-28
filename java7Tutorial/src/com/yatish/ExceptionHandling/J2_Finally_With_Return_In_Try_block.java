package com.yatish.ExceptionHandling;

public class J2_Finally_With_Return_In_Try_block {

	public static void main(String[] args) {
		WithoutCatchAndReturnInTry obj = new WithoutCatchAndReturnInTry();
		obj.WithoutCatchOnFinally();
	}

}

class WithoutCatchAndReturnInTry {
	
	public void WithoutCatchOnFinally() {
		try {
			System.out.println("Before Exception");
			return;	// even if we return in try also, finally will be executed.
		} finally {
			System.out.println("In Finally");
		}
	}
}
