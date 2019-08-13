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

public class BootstrapDropDownExample {

	WebDriver driver = null;
	static private Logger logger = LogManager.getLogger(BootstrapDropDownExample.class);
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

	@Test(priority = 1)
	public void selectWarningOption() {
		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		driver.findElement(
				By.xpath("//button[contains(text(), 'Warning') and @class='btn btn-warning dropdown-toggle']")).click();

		List<WebElement> list = driver
				.findElements(By.xpath("//div[@class ='dropdown-menu' and @aria-labelledby='dropdownMenuButton']//a"));
		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println("List = " + list.get(i).getText());
			if (list.get(i).getText().contains("Something else here")) {
				list.get(i).click();
				System.out.println("Option with 'Something else' selected");
				break;
			}
		}

	}//End selectWarningOption

//	@Test(priority = 1)
//	public void selectFirstDD() {
//		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
//		driver.findElement(By.xpath("//button[contains(text(), 'Dropdown button' )]")).click();
//
//		List<WebElement> list = driver
//				.findElements(By.xpath("//div[@class='dropdown-menu' and @aria-labelledby ='dropdownMenuButton']//a"));
//		System.out.println("Size is =" + list.size());
//
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("List = "+list.get(i).getText());
//			if(list.get(i).getText().contains("else")) {
//				list.get(i).click();
//				System.out.println("Option with 'else' selected");
//				break;
//			}
//		}
//
//	}

//	@Test (priority =2)
//	public void firstTest() {
//		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
//		driver.findElement(By.xpath("//button[contains(text(), 'Dropdown button')]")).click();;
//		List <WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu') and @aria-labelledby='dropdownMenuButton']//a"));
//		
//		System.out.println("Size is ="+list.size());
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("List: "+list.get(i).getText());
//			if(list.get(i).getText().contentEquals("Another action")) {
//				list.get(i).click();
//				System.out.println("Selection = 'Another action'");
//				break;
//			}
//		}
//	}

//		@Test (priority =3)
//		public void thirdTest() {
//			driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");			
//			driver.findElement(By.xpath("//a[contains(text(), 'Dropdown link')]")).click();
//			List <WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu') and @aria-labelledby='dropdownMenuLink']//a"));
//			
//			System.out.println("Size is ="+list.size());
//			for (int i = 0; i < list.size(); i++) {
//			
//				System.out.println("List: "+list.get(i).getText());
//				if(list.get(i).getText().contains("Something")) {
//					list.get(i).click();
//					System.out.println("Selection = 'Something'");
//					break;
//				}
//			}
//	} //End
//		@Test (priority =4)
//		public void fourthTest() {
//			driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");			
//			driver.findElement(By.xpath("//button[contains(text(), 'Secondary')]")).click();
//			List <WebElement> list = driver.findElements(By.xpath("//button[contains(@class,'btn-secondary') and @aria-haspopup='true' and @id='dropdownMenuButton']//a"));
//					
//			//List <WebElement> list = driver.findElements(By.xpath("//button[contains(@class,'btn-secondary') and "
//					//+ "@aria-haspopup='true' and @id='dropdownMenuButton']//a"));
//			
//			System.out.println("Size is ="+list.size());
//			for (int i = 0; i < list.size(); i++) {
//			
//				System.out.println("List: "+list.get(i).getText());
//				if(list.get(i).getText().contains("Something")) {
//					list.get(i).click();
//					System.out.println("Selection = 'Something'");
//					break;
//				}
//			}
//	} //End

	@AfterMethod
	public void tearDown() {
		//driver.close();
		//driver.quit();

	}
}
