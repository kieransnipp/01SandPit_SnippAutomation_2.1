package com.base;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class ThreadPage {

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	static String userDir = System.getProperty("user.dir");
	static String browserName;
	public WebDriver driver;

	public WebDriver multiThreadSetUp(String browserName) {

		System.out.println("Launching browser =" + browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", userDir + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		}
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", userDir + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Starting Firefox");
		}
		if (browserName.equals("opera")) {
			System.setProperty("webdriver.opera.driver", userDir + "/drivers/operadriver.exe");
			driver = new OperaDriver();
			System.out.println("Starting Opera");
		}
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	// @AfterMethod
//	public void threadTearDown() {
//
//		driver.quit();
////		if (!browserName.contains("firefox")) {
////			driver.quit();
////		}
//
//	}
}
