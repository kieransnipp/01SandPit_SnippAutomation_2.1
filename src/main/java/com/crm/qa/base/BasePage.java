package com.crm.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	static String userDir = System.getProperty("user.dir");
	static String browserName;
	public WebDriver driver;

	public WebDriver multiThreadSetUp(String browserName) {
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
			System.setProperty("webdriver.gecko.driver", userDir + "/drivers/opera.exe");
			driver = new FirefoxDriver();
			System.out.println("Starting Firefox");
		}
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	public void threadTearDown() {
		driver.close();
		//driver.quit();
//		if (!browserName.contains("firefox")) {
//			driver.quit();
//		}

	}
}
