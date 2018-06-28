
public class Thread_Executing_different_methods_in_threads_parallelly {

	public static void main(String[] args) {
	
		final x obj = new x();
		Thread t1 = new Thread() {
			public void run() {
				obj.print1();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				obj.print2();
			}
		};
		t1.start();
		t2.start();

	}

}

class x {
	
	
	public void print1() {
		synchronized(new x()) {
			while(true) {
				System.out.println("1");
				try {Thread.sleep(1000);}catch(Exception e) {}
			}
		}
	}
	
	public void print2() {
		synchronized(this) {
			while(true) {
				System.out.println("2");
				try {Thread.sleep(1000);}catch(Exception e) {}
			}
		}
	}
}

