//Accesing the data VIA a static way
package demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FAQ_Page;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class PopUp extends TestBase{

	WebDriver driver = null;
	static private Logger logger = LogManager.getLogger(PopUp.class);
	public static String browserName = null;

	
	@BeforeMethod
	// @BeforeClass
	public void setUp() throws InterruptedException {
		try {
			initialization();
		
			
			TestUtil.runTimeInfo("error", "login successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test (priority =1)
//	public void getBootStrap() {
//		System.out.println("Get google");
//		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
//		String title = driver.getTitle();
//		AssertJUnit.assertEquals("Dropdowns · Bootstrap", title);
//		System.out.println("TestNG_Demoa Test Passed");
//
//	}

	@Test(priority = 1)
	public void switchingToPopUpWindows() {
		//driver.get("http://popuptest.com/goodpopups.html");
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		String parentTitle = driver.getTitle();
		System.out.println("Parent title is "+parentTitle);
		
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		System.out.println("Parent window value = " + parentWindowId);
		System.out.println("Child window value = " + childWindowId);
		
		//Switch to Child
		driver.switchTo().window(childWindowId);
		String childTitle = driver.getTitle();
		System.out.println("Child title is "+childTitle);
		
		
		//Back to parent
		driver.switchTo().window(parentWindowId);
		String tile = driver.getTitle();
		System.out.println("Original title is = "+tile);

	}// End selectWarningOption

	@AfterMethod
	public void tearDown() {
		 //driver.close();
		//driver.quit();

	}
}
