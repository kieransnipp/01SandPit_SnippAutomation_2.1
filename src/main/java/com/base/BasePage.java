//Catalyst
package com.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage implements IBasePage {

	WebDriverWait wait = null;
	WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	static String userDir = System.getProperty("user.dir");
	static String browserName;

	public BasePage(WebDriver drivr) {
		super();
		this.driver = drivr;
		this.wait = new WebDriverWait(driver, 15);
	}

	public BasePage() {
		super();
	}

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

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void selectByOption(By locator, int option) {
		List<WebElement> memberslist = driver
				.findElements(By.xpath("//*[contains(@class,'select2-drop-mask')]//li//a"));
		System.out.println("List size is = " + memberslist.size());

		for (int i = 0; i < memberslist.size(); i++) {
			System.out.println(memberslist.get(i).getText());
			if (memberslist.get(i).getText().endsWith("A")) {
				memberslist.get(i).click();
				break;
			}

		}
	}

	public static String whatsTodaysDateAmerican() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todaysAmericanDate = formatter.format(date);

		return todaysAmericanDate;

	}

	public static String whatsTodaysDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date();
		String todaysDate = formatter.format(date);

		return todaysDate;

	}

	public void switchToWindowNew() { // To switch to Report you want to see
		Set<String> allWindows = driver.getWindowHandles();

		ArrayList<String> tabs = new ArrayList<>(allWindows);
		driver.switchTo().window(tabs.get(1));
		System.out.println("Switched window");
		System.out.println("Title of page switched to is = " + driver.getTitle());

		int count = allWindows.size();
		System.out.println("Total windows are =" + count);

	}

	public void selectCorrectCountryByLocale(By countryCde, String locale) {
		String countrySelected = countryCde.toString();
		System.out.println("Locale is = " + locale);

		Select dropdown = new Select(driver.findElement(countryCde));

		if (locale.contentEquals("es")) {
			dropdown.selectByVisibleText("Spain");
		} else if (locale.contentEquals("pl")) {
			dropdown.selectByVisibleText("Poland");
		} else if (locale.contentEquals("en")) {
			dropdown.selectByVisibleText("Ireland");
		} else if (locale.contentEquals("de")) {
			dropdown.selectByVisibleText("Germany");
		} else if (locale.contentEquals("it")) {
			dropdown.selectByVisibleText("Italy");
		} else if (locale.contentEquals("zh")) {
			dropdown.selectByVisibleText("China");
		} else if (locale.contentEquals("fr")) {
			dropdown.selectByVisibleText("France");
		} else if (locale.contentEquals("sv")) {
			dropdown.selectByVisibleText("Sweden");
		} else if (locale.contentEquals("CA")) {
			dropdown.selectByVisibleText("Canada");

		}

	}// End selectCorrectCountryByLocale

	public void switchToFrame(String name) { // Fixed on 31/01/2020
		driver.switchTo().frame(driver.findElement(By.name(name)));
		// driver.switchTo().frame(name);
	}

	public void switchToFrameById(String name) { // Fixed on 31/01/2020
		driver.switchTo().frame(driver.findElement(By.id(name)));
		System.out.println("Switched to frame " + name);
		// driver.switchTo().frame(name);
	}

	public void switchToFrameByFrameNumber(String name) { // Fixed on 31/01/2020
		driver.switchTo().frame(name);
		System.out.println("Switched to frame " + name);
		// driver.switchTo().frame(name);
	}

	public String getPageHeader(By locator) {
		return getElement(locator).getText();

	}

	// generic util wrappers
	public void click(By locator) {
		driver.findElement(locator).click();
		System.out.println("Clicked " + locator);
	}

	public void click(String text) {
		driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]")).click();
		System.out.println("Clicked on " + text);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void doSendKeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public String doGetText(By locator) {
		return driver.findElement(locator).getText();
	}

	public boolean isElementDisplayed(By locator) { // Wrapper function
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			System.out.println("Element is displayed = " + locator);
			return true;
		} catch (Exception e) {
			System.out.println("Some error occured for the element " + locator.toString());
			e.printStackTrace();
		}
		return false;

	}

	public boolean isLinkClickable(By by) {
		List<WebElement> wb = driver.findElements(by);
		for (WebElement we : wb) {
			if (we.isDisplayed() && we.isEnabled()) {
				we.click();
				return true;

			}
		}
		return false;
	}

	public boolean findExactText(String string) {
		WebElement searchName = driver.findElement(By.xpath("//*[text()='" + string + "']"));
		if (searchName.isDisplayed()) {
			return true;
		}

		return false;

	}

	public int numberOfTimesStringIsDisplayed(String string) {
		List<WebElement> numberTimes = driver.findElements(By.xpath("//*[contains(text(), '" + string + "')]"));

		int duplicateTimes = numberTimes.size();
		System.out.println("Text is displayed " + duplicateTimes + " times");
		return duplicateTimes;

	}

	public boolean isExactTextDisplayed(String string) {
		WebElement searchName = driver.findElement(By.xpath("//*[text()='" + string + "']"));

		if (searchName.isDisplayed()) {
			System.out.println("Text '" + string + "' displayed = true!");
			return true;
		}
		return false;

	}

	public boolean isTextDisplayed(String string) {
		WebElement searchName = driver.findElement(By.xpath("//*[contains(text(), '" + string + "')]"));

		if (searchName.isDisplayed()) {
			System.out.println("Text '" + string + "' displayed = true!");
			return true;
		} else
			return false;

	}

	public boolean isTextNotDisplayed(String string) {
		WebElement searchName = driver.findElement(By.xpath("//*[contains(text(), '" + string + "')]"));

		if (!searchName.isDisplayed()) {
			return true;
		}
		return false;
	}

	public WebElement getElement(By locator) { // Wrapper function
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Some error occured for the element " + locator.toString());
			e.printStackTrace();
		}
		return element;

	}
	
	public void waitForTextElementPresent(String waitForString) {
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[contains(text(),'"+waitForString+"')]")));

	}

	public void waitForElementPresent(By locator){
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			System.out.println("Waiting for element " + locator);
		} catch (Exception e) {
			System.out.println("Some excpeption/error occured waiting for the element " + locator.toString());
			e.printStackTrace();
		}

	}

	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Some excpeption/error occured waiting for the element " + title);
			e.printStackTrace();
		}

	}

	public <TPage extends IBasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	} // End TPage

	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	// JavaScript functions
	public Boolean clickOnByJS(By locator) {
		return ((JavascriptExecutor) locator).executeScript("return document.readyState").equals("complete");

	};

	public Boolean waitPageLoaded(By locator) {
		return ((JavascriptExecutor) locator).executeScript("return document.readyState").equals("complete");

	};

	public static boolean waitPageLoadedByDriver(WebDriver driver) {
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
				|| ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}

	public String enterDate(By element, String dateEntered) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]",
				// driver.findElement(By.id("memberregistrationDOBInput")), dateEntered);
				driver.findElement(element), dateEntered);

		return dateEntered;
	}

	public String enterText(By element, String stringEntered) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]",
				// driver.findElement(By.id("memberregistrationDOBInput")), dateEntered);
				driver.findElement(element), stringEntered);

		return stringEntered;
	}

	// Extra JavaScript functions - Demo in demo.TOP_UAT_ToolsMailTest
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element, driver);// 1
			changeColor(bgcolor, element, driver);// 2
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");

	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static void clickElementByJS_By(By element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static void checkTAndC(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("docment.getElementById('termsconditions').checked=true;");

	}

	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickOnElement(By element) { // < ---- This one doesnt work
		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]",
				// driver.findElement(By.id("memberregistrationDOBInput")), dateEntered);
				driver.findElement(element));

	}
	
	public void scollDownOrUp(String pixels) {  //350 =down -350 = up
	   JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,"+pixels+")", "");
       //js.executeScript("window.scrollBy(0,350)", "");
	}
	
	public void scollToBottomOfPage() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		  }
	public void scollHorizontaly(WebElement Element) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 //WebElement Element = driver.findElement(By.linkText("Auto Testing"));
		  js.executeScript("arguments[0].scrollIntoView();", Element);

		  }
	
	
	

	public void threadTearDown() throws IOException {
		driver.close();

		if (!browserName.contains("firefox")) {
			driver.quit();
		}
	}

}
