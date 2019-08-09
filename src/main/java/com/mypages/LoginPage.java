/**
 * 
 */
package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.pages.DetailsPage;

/**
 * @author kiera
 *
 */
public class LoginPage extends BasePage {

	// page locators
	private By emailId = By.name("Email");
	private By passWord = By.name("Password");
	private By submitButton = By.name("loginButton");
	private By headerImg = By.xpath("//*[@class='brand-image']");
	//private By headerTitle = By.className("UsersName");
	private By headerText = By.linkText("HOW IT WORKS");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	// Getters
	@Override
	public WebElement getFooterContactUs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isElementDisplayed(By locator) {
		return isElementDisplayed(locator);

	}

	public WebElement getEmailId() {
		return getElement(emailId); // Returning email
	}

	public WebElement getPassWord() {
		return getElement(passWord); // Returning pw
	}

	public WebElement getSubmit() {
		return getElement(submitButton);
	}

	public String getLoginPageTitle() {
		return getPageTitle(); // From BasePage
	}

	public String getLoginPageURL() {
		return getPageURL(); // From BasePage
	}

	public String getPageHeaderTitle() {
		return getPageHeader(headerText); // From BasePage

	}

	// Three examples of method overloading
	public HomePage doLogin(String userName, String passWord) {
		getEmailId().sendKeys(userName);
		getPassWord().sendKeys(passWord);
		getSubmit().click();

		return getInstance(HomePage.class);
	}

	// Overloading method
	public void doLogin() {
		getEmailId().sendKeys("wrong");
		getPassWord().sendKeys("wronger");
		getSubmit().click();
	}

	// Example negative test
	public void doLogin(String userName) {

		// username: kieran@kieran.com
		if (userName.contains("userName")) {
			getEmailId().sendKeys(userName.split(":")[1].trim());
		} else if (userName.contains("passWord")) {
			getEmailId().sendKeys(userName.split(":")[1].trim());
		}

		getSubmit().click();

	} // End doLogin

}
