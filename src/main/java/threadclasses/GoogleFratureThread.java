package threadclasses;

import java.io.IOException;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

public class GoogleFratureThread extends Thread {

	public String browserName;
	public GooglePage googlePage = null;
	private Fairy fairy = null;
	public Person person = null;

	protected Fairy GetLocalFairy() {
		return this.fairy;
	}

	public GoogleFratureThread(String threadName, String browserName) {
		super(threadName);
		this.browserName = browserName;
		googlePage = new GooglePage();

	}

	@Override
	public void run() {
		System.out.println("thread -- started " + Thread.currentThread().getName());
		// Create person object

		System.out.println("Thread is " + Thread.currentThread());
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

		try {
			System.out.println("Inside the try");
			googlePage.multiThreadSetUp(this.browserName);
			googlePage.googleSearch();

		} catch (Exception e) {
			System.out.println("Stach trace is =" + e.getStackTrace());
			googlePage.threadTearDown();
			
			// } finally {
//			try {
//
//			} catch (Exception e) {
//				
//				e.printStackTrace();
//			}

		}
		
		System.out.println("Thread ended =" + Thread.currentThread().getId());

	} // End run

}
