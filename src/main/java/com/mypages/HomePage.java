package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private By footerContacUs = By.linkText("CONTACT US");
	private By headerTitle = By.linkText("Register");

	public HomePage(WebDriver driver) {
		super(driver);

	}

	// Page actions
	public WebElement getFooterContactUs() {
		return getElement(footerContacUs);
	}

	
	
	public String getLoginPageTitle() {
		return getPageTitle(); // From BasePage
	}

	public String getheaderTitle() {
		return getPageHeader(headerTitle);
	}

}
