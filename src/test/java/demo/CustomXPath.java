//Accesing the data VIA a static way
package demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.codeborne.selenide.WebDriverRunner;

public class CustomXPath {

	WebDriver driver = null;
	static private Logger logger = LogManager.getLogger(CustomXPath.class);
	public static String browserName = null;

	@BeforeMethod
	public void setUpTest() {
		System.out.println("Second test running");
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties(); // Sets the browserName for this class

		if (PropertiesFile.browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			if (PropertiesFile.browser.equalsIgnoreCase("firefox")) {
				System.out.println("Launching firefox");
				// browserName = ((Object) driver).Firefox("drivers/geckodriver.exe");
				System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			WebDriverRunner.setWebDriver(driver);
		}

	} // End setUpTest

	// @Test (priority =1)
//	public void getBootStrap() {
//		System.out.println("Get google");
//		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
//		String title = driver.getTitle();
//		AssertJUnit.assertEquals("Dropdowns · Bootstrap", title);
//		System.out.println("TestNG_Demoa Test Passed");
//
//	}

//	@Test(priority = 1)
//	public void selectWarningOption() {
//		driver.get("https://www.ebay.com/");
//		WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));
//		WebElement sendBtn = driver.findElement(By.id("gh-btn"));
//		searchInput.sendKeys("Steal my kiss");
//		sendBtn.sendKeys(Keys.ENTER);
//		
//
//	}//End selectWarningOption
	
	@Test(priority = 1)
	public void countLinks() {
		driver.get("https://www.ebay.com/");
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links is ="+links.size());
		
		for (int i = 0; i < links.size(); i++) {
			String x = links.get(i).getText().trim();
			String lookinFor = "Refurb Tech";
			if (x.contains("Refurb Tech")) {
				System.out.println("Text '"+lookinFor+"' found!!!!");
				break;
			}
			System.out.println(x);
			
		}
		
		

	}//End selectWarningOption



	@AfterMethod
	public void tearDown() {
		//driver.close();
		//driver.quit();

	}
}
