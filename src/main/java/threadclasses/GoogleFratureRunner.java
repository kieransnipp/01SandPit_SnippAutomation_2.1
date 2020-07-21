package threadclasses;

import java.io.IOException;

public class GoogleFratureRunner {

	public static void main(String[] args) throws IOException {

		Thread t1 = new GoogleFratureThread("chrome thread", "chrome");
		Thread t2 = new GoogleFratureThread("Firefox thread", "firefox");
		Thread t3 = new GoogleFratureThread("Opera thread", "opera");

		System.out.println("Thread started...");
		//t1.start();
		//t2.start();
		t3.start();

	}

}
