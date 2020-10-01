// Catalyst base 
package com.base;

import org.testng.Assert;
import java.util.Random;
import java.sql.Time;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.LocaleUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.base.*;
import com.google.common.collect.ImmutableMap;
import com.qa.util.Helper;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	public static WebDriver driver;

	public static BasePage page;
	public static WebDriverWait wait;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;

	static String userDir = System.getProperty("user.dir");
	public Fairy fairy = null;

	public ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	HttpURLConnection huc = null;
	int respCode = 200;
	static String browserName;

	By blueBOrdersNext = By
			.xpath("//*[@id='myOrder']/app-snipp-rewards-orders/div/div/div/div/mat-paginator/div/div/div/button[2])");

	protected Fairy GetLocalFairy() {
		return this.fairy;
	}

	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/" + "/qa/config/config.properties");
			prop.load(ip);
		

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // End TestBase

	public static String whatsTodaysDateSOAP() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String todaysDate = formatter.format(date);

		return todaysDate;

	}

	public static String whatsTodaysDateEpos() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date();
		String todaysDate = formatter.format(date);

		return todaysDate;

	}

	public static synchronized WebDriver getDriver() {
		return driver;
	}

	

	public boolean searchOnPageForData(String searchForThis) throws Exception {
		System.out.println("Searching for text " + searchForThis);
		boolean isDisplayed = false;
		System.out.println("Start of while");
		Thread.sleep(1000);

		if (driver.getPageSource().contains(searchForThis)) {
			isDisplayed = true;

		} else
 
		{
			isDisplayed = false;
			System.out.println("Search for the string '" + searchForThis + "' is = " + isDisplayed);
			System.out.println("Search for text next not found");
		}

		System.out.println("Search for the string '" + searchForThis + "' is = " + isDisplayed);
		return isDisplayed;

	} // End while

	

	public static void initialization() throws IOException {

		browserName = Helper.GetOverRideJenkinsBrowser("browser");
		String testURL = Helper.GetOverRideJenkinsURL("url2"); 
		String downloadSpeed = Helper.GetOverRideJenkinsDownloadSpeed("downloadSpeed");
		String uploadSpeed = Helper.GetOverRideJenkinsURL("uploadSpeed");

		// Chrome
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", userDir + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();

			// Chrome headless
		} else if (browserName.equals("chrome_headless")) {
			System.setProperty("webdriver.chrome.driver", userDir + "/drivers/chromedriver.exe");

			ChromeOptions options = new ChromeOptions(); // Added
			options.addArguments("--disable-extensions"); // Added
			options.addArguments("--dns-prefetch-disable"); // Added
			options.addArguments("--disable-gpu"); // Added
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors"); // Added
			options.addArguments("--no-sandbox"); // Added 10/02/2020
			driver = new ChromeDriver(options); // Added

		} else

		// Firefox headless
		if (browserName.equals("firefox_headless")) {

			FirefoxBinary firefoxBinary = new FirefoxBinary();
			firefoxBinary.addCommandLineOptions("--headless");

			System.setProperty("webdriver.gecko.driver", userDir + "/drivers/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinary(firefoxBinary);
			driver = new FirefoxDriver(firefoxOptions);

			// Firefox
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", userDir + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Starting Firefox");

			// Commented this 4 lines out to make set the network speed
			e_driver = new EventFiringWebDriver(driver);
			//eventListener = new WebEventListener();
		//	e_driver.register(eventListener);
			driver = e_driver;
		} else if (browserName.equals("opera")) {
			System.setProperty("webdriver.opera.driver", userDir + "/drivers/operadriver.exe");
			driver = new OperaDriver();
			System.out.println("Starting Opera");

			// Commented this 4 lines out to make set the network speed
			e_driver = new EventFiringWebDriver(driver);
			//eventListener = new WebEventListener();
			//e_driver.register(eventListener);
			driver = e_driver;
		} else if (browserName.equals("msedge")) {
			System.setProperty("webdriver.edge.driver", userDir + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			System.out.println("Starting Ms Edge");

			// Commented this 4 lines out to make set the network speed
			e_driver = new EventFiringWebDriver(driver);
		//eventListener = new WebEventListener();
		//	e_driver.register(eventListener);
			driver = e_driver;
		}

		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver

//Commented this 4 lines out to make set the network speed
		// e_driver = new EventFiringWebDriver(driver);
		// eventListener = new WebEventListener();
		// e_driver.register(eventListener);
		// driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//
		int downloadSpeedInt = Integer.valueOf(downloadSpeed);
		int uploadSpeedInt = Integer.valueOf(uploadSpeed);
		System.out.println("downloadSpeedInt = " + downloadSpeedInt);
		System.out.println("uploadSpeedInt = " + uploadSpeedInt);

		// Insert download speed here
		if (downloadSpeedInt > 0 && uploadSpeedInt > 0) {
			CommandExecutor executor = ((RemoteWebDriver) driver).getCommandExecutor();
			Map<String, Comparable> map = new HashMap<String, Comparable>();
			map.put("offline", false);
			map.put("latency", 5);
			map.put("download_throughput", downloadSpeedInt);
			map.put("upload_throughput", uploadSpeedInt);

			Response response = executor.execute(new Command(((RemoteWebDriver) driver).getSessionId(),
					"setNetworkConditions", ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map))));
		}

		driver.get(testURL);

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		page = new BasePage(driver);

	} // End initialization

	@BeforeMethod
	public void setUpTest() throws Exception {
		System.out.println("Running now");

	}

//	@AfterMethod(alwaysRun = true)
//	public void tearDown() throws Exception {
//		driver.close();
//
//		if (!browserName.contains("firefox")) {
//			driver.quit();
//		}
//	}

	public boolean checkLinks() {
		String url = Helper.GetOverRideJenkinsURL("url2");
		// String url = prop.getProperty("url");

		String homePage = Helper.GetOverRideJenkinsURL("url2");
		// String homePage = prop.getProperty("url");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
					System.out.println("Broken url code = " + respCode);
					return false;
				} else {
					System.out.println(url + " is a valid link");

				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // End while

		System.out.println(" ***********  End of link checks for this page ***************** ");

		return true;
	}

	public String getTime() {

		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		String time = formatter.format(date);
		System.out.println(formatter.format(date));

		return time;
	}

}