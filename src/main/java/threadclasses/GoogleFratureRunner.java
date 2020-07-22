package threadclasses;

import java.io.IOException;

public class GoogleFratureRunner {

	public static void main(String[] args) throws Exception {

//		Thread t1 = new GoogleFratureThread("chrome thread", "chrome");
//		Thread t2 = new GoogleFratureThread("Firefox thread", "firefox");
//		Thread t3 = new GoogleFratureThread("Opera thread", "opera");
//		Thread t4 = new GoogleFratureThread("chrome thread", "chrome");
//		Thread t5 = new GoogleFratureThread("chrome thread", "chrome");
//		Thread t6 = new GoogleFratureThread("chrome thread", "chrome");
//
//		System.out.println("Thread started...");
//
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
//		t6.start();

		for (int i = 0; i < 5; i++) {
			new GoogleFratureThread("chrome thread", "chrome").start();
			new GoogleFratureThread("Firefox thread", "firefox").start();
			new GoogleFratureThread("Opera thread", "opera");
		}

	}

}
